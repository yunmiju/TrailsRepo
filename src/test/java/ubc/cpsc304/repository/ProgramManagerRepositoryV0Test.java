package ubc.cpsc304.repository;

import org.junit.jupiter.api.Test;
import ubc.cpsc304.domain.ProgramInfo;

import java.sql.SQLException;

class ProgramManagerRepositoryV0Test {
    ProgramRepositoryV0 repository = new ProgramRepositoryV0();
    @Test
    void crud() throws SQLException {
        ProgramInfo programInfo = new ProgramInfo(6, 1002, "Explore Nature", 10);
        repository.save(programInfo);
    }
}