package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.jdbc.support.JdbcUtils;
import ubc.cpsc304.database.DBConnectionUtil;
import ubc.cpsc304.domain.Countries;

import java.sql.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;


@Slf4j
public class CountriesRepositoryV1 {

    public Countries save(Countries countries) throws SQLException {
        String sql = "insert into Countries " +
                    "(country_name) " +
                    "values (?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, countries.getCountryName());
            pstmt.executeUpdate();
            return countries;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public Set<String> findAll() throws SQLException {
        String sql;

        sql = "select * from countries";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            Set<String> list = new HashSet<String>();
            while (rs.next()) {
                String country = rs.getString("country_name");
                System.out.println("country_name=" + country);
                list.add(country);
            }
            return list;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }

    public Countries findByName(String countryName) throws SQLException {
        String sql;
        //sql = "select * from countries where country_name='"+countryName+"'";
        sql = "select * from countries where country_name=?";
        System.out.println(sql);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, countryName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("name : " + rs.getString(1));
                Countries countries = new Countries();
                String name = rs.getString("country_name").trim();
                countries.setCountryName(name);
                return countries;
            } else {
                throw new NoSuchElementException("countries not found countryname= " + countryName);
            }

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

}
