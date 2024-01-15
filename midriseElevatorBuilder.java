public class midriseElevatorBuilder extends elevatorBuilder {
    @Override
    void buildCapacity() {
        elevator.setCapacity(getRandomCurrentCapacity());
    }

    @Override
    void buildOCtime() {
        elevator.setOCtime(1500);
    }

    @Override
    void buildHouseType() {
        elevator.setType(rise.MIDRISE);
    }

    @Override
    void buildRoadTime() {
        elevator.setRoadTime(1500);
    }
    private static int getRandomCurrentCapacity()
    {
        return (int) (Math.random() * 600)+1;
    }
}
