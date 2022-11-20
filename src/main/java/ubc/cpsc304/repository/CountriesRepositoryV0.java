package ubc.cpsc304.repository;
import org.slf4j.Logger;
import org.springframework.jdbc.support.JdbcUtils;
import ubc.cpsc304.database.DBConnectionUtil;
import ubc.cpsc304.domain.Country;
import lombok.extern.slf4j.Slf4j;
import java.util.NoSuchElementException;

import java.sql.*;


@Slf4j
public class CountriesRepositoryV0 {

    public Country save(Country country) throws SQLException {
        String sql;
        sql = "insert into Countries " +
                "(country_name) " +
                "values (?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, country.getCname());
            pstmt.executeUpdate();
            return country;
        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }

    }
    public Country findAll(String countryName) throws SQLException {
        String sql;
        sql = "select * from countries";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Country country = new Country();
                country.setCname(rs.getString("country_name"));
                return country;
            }
            throw new NoSuchElementException("countries not found");

        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }
    public Country findByName(String countryName) throws SQLException {
        String sql;
        sql = "select * from countries where country_name='CANADA'";
        // sql = "select * from countries where country_name=?";
        System.out.println(sql);
        Connection con = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // pstmt.setString(1, countryName);
            rs = pstmt.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                Country country = new Country();
                country.setCname(rs.getString("country_name"));
                return country;
            } else {
                throw new NoSuchElementException("countries not found countryname= " + countryName);
            }

        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        connectionHandler(con, stmt, rs, log);
    }

    static void connectionHandler(Connection con, Statement stmt, ResultSet rs, Logger log) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);

        //        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                log.info("error", e);
//            }
//        }
//        if (stmt != null) {
//            try {
//                stmt.close(); // Exception
//            } catch (SQLException e) {
//                log.info("error", e);
//            }
//        }
//
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                log.info("error", e);
//            }
//        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

}
