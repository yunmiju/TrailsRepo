//package ubc.cpsc304.repository;
//
//import ubc.cpsc304.database.DBConnectionUtil;
//import ubc.cpsc304.domain.ProgramInfo;
//import lombok.extern.slf4j.Slf4j;
//
//import java.sql.*;
//
//@Slf4j
//public class ProgramRepositoryV0 {
//
//    public ProgramInfo save(ProgramInfo programInfo) throws SQLException {
//        String sql;
//        sql = "insert into Program_info " +
//                "(id, visitor_center_id, program_name, capacity) " +
//                "values (?, ?, ?, ?)";
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = getConnection();
//            pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, programInfo.getId());
//            pstmt.setInt(2, programInfo.getVisitorCenterId());
//            pstmt.setString(3, programInfo.getProgramName());
//            pstmt.setInt(4, programInfo.getCapacity());
//            pstmt.executeUpdate();
//            return programInfo;
//        } catch (SQLException e){
//            log.error("db error", e);
//            throw e;
//        } finally {
//            close(con, pstmt, null);
//        }
//
//    }
//
//    private void close(Connection con, Statement stmt, ResultSet rs) {
//        CountriesRepositoryV0.connectionHandler(con, stmt, rs, log);
//    }
//
//    private Connection getConnection() {
//
//        return DBConnectionUtil.getConnection();
//    }
//}
