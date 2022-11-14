package ubc.cpsc304.controller;

public class Program {
    private final int id;
    private final int visitorCenterId;
    private final String programName;
    private final int capacity;

    public Program(int id, int visitorCenterId, String programName, int capacity) {
        this.id = id;
        this.visitorCenterId = visitorCenterId;
        this.programName = programName;
        this.capacity = capacity;
    }

    public int getId() {
        return this.id;
    }

    public int getVisitorCenterId() {
        return this.visitorCenterId;
    }

    public String getProgramName() {
        return this.programName;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
