package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.JdbcUtils;
import ubc.cpsc304.domain.ProgramInfo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;


@Slf4j
public class ProgramInfoRepositoryV1 {

    private final DataSource dataSource;

    public ProgramInfoRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProgramInfo save(ProgramInfo programInfo) throws SQLException {
        String sql;
        sql = "insert into Program_info " +
                "(id, visitor_center_id, program_name, capacity) " +
                "values (?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, programInfo.getId());
            pstmt.setInt(2, programInfo.getVisitorCenterId());
            pstmt.setString(3, programInfo.getProgramName());
            pstmt.setInt(4, programInfo.getCapacity());
            pstmt.executeUpdate();
            return programInfo;
        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }

    }

    public Set<String> findAll() throws SQLException {
        String sql;
        sql = "select * from PROGRAM_INFO";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Map<Integer, String> programs = new HashMap<>();
                Set<ProgramInfo> programsSet = new HashSet<ProgramInfo> ();
                Set<String> programNames = new HashSet<String> ();
                while (rs.next()) {
                    String programName = rs.getString("program_name");
                    System.out.println("country_name= " + programName);
                    programNames.add(programName);
                }
                return programNames;
            } else {
                throw new NoSuchElementException("countries not found");
            }
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            if(pstmt != null) try{ pstmt.close();} catch(SQLException e){};

            if(rs != null) try{ rs.close();} catch(SQLException e){};

            if(con != null) try{ con.close();} catch(SQLException e){};
        }
    }

    public ProgramInfo findByVisitorCenterId(int visitorCenterId) throws SQLException {
        String sql;
        //sql = "select * from countries where VISITOR_CENTER_ID=visitorCenterId";
        sql = "select * from PROGRAM_INFO where VISITOR_CENTER_ID=?";
        System.out.println(sql);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, visitorCenterId);
            rs = pstmt.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                ProgramInfo target = new ProgramInfo();
                int id = rs.getInt("ID");
                String programName = rs.getString("program_name").trim();
                int capacity = rs.getInt("CAPACITY");
                target.setVisitorCenterId(visitorCenterId);
                target.setId(id);
                target.setCapacity(capacity | 10);
                return target;
            } else {
                throw new NoSuchElementException("program not found visitor_Center_Id= " + visitorCenterId);
            }

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
    }

    private Connection getConnection() throws SQLException {
        Connection con = dataSource.getConnection();
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }
}
