public class Director {
    elevatorBuilder builder;

    public void setBuilder(elevatorBuilder builder) {
        this.builder = builder;
    }
    elevator buildElevator(int id, int floors) {
        builder.createElevator();
        builder.buildCapacity();
        builder.buildOCtime();
        builder.buildHouseType();

        elevator elevator = builder.getElevator();
        elevator.setFloors(floors);
        elevator.setId(id);
        return elevator;
    }
}
