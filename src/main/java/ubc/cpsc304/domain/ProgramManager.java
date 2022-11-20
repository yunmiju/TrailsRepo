package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class ProgramManager
{
    private int programId;
    private int magagerId;

    public ProgramManager() {}

    public ProgramManager(int programId, int magagerId) {
        this.programId = programId;
        this.magagerId = magagerId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getMagagerId() {
        return magagerId;
    }

    public void setMagagerId(int magagerId) {
        this.magagerId = magagerId;
    }
}
