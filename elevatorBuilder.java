public abstract class elevatorBuilder {
    elevator elevator;
    void createElevator() {
        elevator = new elevator();
    }
    abstract void buildCapacity();
    abstract void buildOCtime();
    abstract void buildHouseType();
    abstract void buildRoadTime();
    elevator getElevator() {
        return elevator;
    }
}
