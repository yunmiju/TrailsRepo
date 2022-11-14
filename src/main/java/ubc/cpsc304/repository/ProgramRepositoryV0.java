package ubc.cpsc304.repository;

import ubc.cpsc304.database.DBConnectionUtil;
import ubc.cpsc304.model.ProgramInfo;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class ProgramRepositoryV0 {

    public ProgramInfo save(ProgramInfo programInfo) throws SQLException {
        String sql;
        sql = "insert into Program_info(id, visitor_center_id, program_name, capacity) values (?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ProgramInfo.getId());
            pstmt.setInt(2, ProgramInfo.getVisitorCenterId());
            pstmt.setString(3, ProgramInfo.getProgramName());
            pstmt.setInt(4, ProgramInfo.getCapacity());
            pstmt.executeUpdate();
            return programInfo;
        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }

    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.inf("error", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close(); // Exception
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
