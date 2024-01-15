public class highriseElevatorBuilder extends elevatorBuilder {
    @Override
    void buildCapacity() {
        elevator.setCapacity(getRandomCurrentCapacity());
    }

    @Override
    void buildOCtime() {
        elevator.setOCtime(2000);
    }

    @Override
    void buildHouseType() {
        elevator.setType(rise.HIGHRISE);
    }

    @Override
    void buildRoadTime() {
        elevator.setRoadTime(1000);
    }
    private static int getRandomCurrentCapacity()
    {
        return (int) (Math.random() * 1000)+1;
    }


}
