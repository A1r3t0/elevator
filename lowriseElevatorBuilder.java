public class lowriseElevatorBuilder extends elevatorBuilder {
    @Override
    void buildCapacity() {
        elevator.setCapacity(getRandomCurrentCapacity());
    }

    @Override
    void buildOCtime() {
        elevator.setOCtime(1000);
    }

    @Override
    void buildHouseType() {
        elevator.setType(rise.LOWRISE);
    }

    @Override
    void buildRoadTime() {
        elevator.setRoadTime(2000);
    }
    private static int getRandomCurrentCapacity()
    {
        return (int) (Math.random() * 300)+1;
    }

}
