import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class elevatorEx {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Director director = new Director();
        director.setBuilder(new highriseElevatorBuilder());
        elevator elevator1 = director.buildElevator(1, 25);
        director.setBuilder(new lowriseElevatorBuilder());
        elevator elevator2 = director.buildElevator(2, 4);
        ArrayList<elevator> elevators = new ArrayList<>();
        Thread elevatorThread1 = new Thread(elevator1);
        elevatorThread1.start();
        elevators.add(elevator1);
        elevators.add(elevator2);
        Thread elevatorThread2 = new Thread(elevator2);
        elevatorThread2.start();
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < elevators.size(); i++) {
            ids.add(elevators.get(i).getId());
        }
        while (true) {
            System.out.print("Введите id лифта: ");
            String r = reader.readLine();
            int r1 = Integer.parseInt(r); //id лифта
            if (ids.contains(r1)) {
                for (int i = 0; i < elevators.size(); i++) {
                    if (r1 == elevators.get(i).getId()) {
                        System.out.println("Вы выбрали лифт с id: " + elevators.get(i).getId() + ".");
                        System.out.println("Введите 1 - для получения информации о лифте, 2 - для остановки лифта,");
                        System.out.println("3 - для запуска лифта, 4 - для направления лифта на какой-либо этаж.");
                        String action = reader.readLine();
                        if (action.equals("1")) {
                            System.out.println("Загруженность лифта: " + elevators.get(i).getCapacity() + " кг.");
                            System.out.println("Текущий этаж: " + elevators.get(i).getCurrentFloor() + ".");
                            System.out.println("Лифт едет на " + elevators.get(i).getFloorToGo() + " этаж.");
                        } else if (action.equals("2")) {
                            elevators.get(i).stopElevator();
                            System.out.println("Лифт с id: " + elevators.get(i).getId() + " остановлен.");
                        } else if (action.equals("3")) {
                            elevators.get(i).startElevator();
                            System.out.println("Лифт с id: " + elevators.get(i).getId() + " вновь запущен.");
                        } else if (action.equals("4")) {
                            String floor = reader.readLine();
                            int floorInt = Integer.parseInt(floor);
                            elevators.get(i).currentFloor = floorInt;
                            System.out.println("Лифт направлен на " + floorInt + " этаж!");
                        }
                    } //else {
                      //  System.out.println("Лифта с таким id нет!");
                    //}
                }
            } else {
                System.out.println("Лифта с таким id нет!");
            }

        }


    }
}
