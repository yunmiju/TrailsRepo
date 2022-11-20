package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class ProgramInfo {
    private int id;
    private int visitorCenterId;
    private String programName;
    private int capacity;

    public ProgramInfo() {

    }

    public ProgramInfo(int id, int visitorCenterId, String programName, int capacity) {
        this.id = id;
        this.visitorCenterId = visitorCenterId;
        this.programName = programName;
        this.capacity = capacity | 10;
    }
}
