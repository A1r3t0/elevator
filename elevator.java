public class elevator implements Runnable {
    private int id; //id лифта
    private int floors; //количество этажей в доме
    private int capacity; //грузоподъёмность
    private int OCtime; //время 1 открытия дверей или 1 закрытия
    private int roadTime; // время езды между ближайшими этажами
    public int currentFloor; //текущий этаж
    private int floorToGo; // этаж на который надо ехать
    rise type; //тип дома

    public void setRoadTime(int roadTime) {
        this.roadTime = roadTime;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setOCtime(int OCtime) {
        this.OCtime = OCtime;
    }

    public void setType(rise type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "elevator{" +
                "id=" + id +
                ", floors=" + floors +
                ", capacity=" + capacity +
                ", OCtime=" + OCtime +
                ", roadTime=" + roadTime +
                ", type=" + type +
                '}';
    }
    // Поле для флага остановки
    private volatile boolean stopRequested = false;

    // Метод для остановки потока
    public void stopElevator() {
        stopRequested = true;
    }
    public void startElevator() {
        stopRequested = false;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        currentFloor = 1;
        while (!current.isInterrupted() && !stopRequested) {
            try {
                floorToGo = getRandomFloor(floors);
                while (currentFloor != floorToGo) {
                    //System.out.println("Этаж на который нужно попасть: " + floorToGo);
                    if (currentFloor < floorToGo) {
                        Thread.sleep(roadTime);
                        currentFloor++;
                        //System.out.println("Этаж на который надо попасть выше, текущий этаж: " + currentFloor);
                    } else {
                        Thread.sleep(roadTime);
                        currentFloor--;
                        //System.out.println("Этаж на который надо попасть ниже, текущий этаж: " + currentFloor);
                    }
                }
                //System.out.println("Мы на этаже, на который нужно попасть, текущий этаж: " + currentFloor);
                //System.out.println("Открываем двери");
                Thread.sleep(OCtime);
                //System.out.println("Закрываем двери");
                Thread.sleep(OCtime);

                // Выбираем новый этаж после закрытия дверей
                floorToGo = getRandomFloor(floors);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Переустанавливаем флаг прерывания
            }
        }
    }
    // Метод для получения статуса остановки
    public boolean isStopRequested() {
        return stopRequested;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getId() {
        return id;
    }

    public int getFloorToGo() {
        return floorToGo;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRandomFloor(int floors)
    {
        return (int) (Math.random() * floors) + 1;
    }
}
