package ubc.cpsc304.repository;

import org.slf4j.Logger;
import org.springframework.jdbc.support.JdbcUtils;
import ubc.cpsc304.database.DBConnectionUtil;
import ubc.cpsc304.domain.Countries;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.pool.OracleDataSource;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.sql.*;
import java.util.Set;

@Slf4j
public class CountriesRepositoryV0 {

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
    String sql = "select * from countries where COUNTRY_NAME=?";
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      // pstmt = PreparedStatement(con.prepareStatement(sql), sql, false);
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, countryName);
      rs = pstmt.executeQuery();
      System.out.println(rs);
      if (rs.next()) {
        Countries countries = new Countries();

        System.out.println(rs.getString(1));
        String name = rs.getString(1).trim();
        countries.setCountryName(name);

        return countries;
      } else {
        throw new NoSuchElementException("countries not found countryname= " +
            countryName);
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

//  private void close(Connection con, Statement stmt, ResultSet rs) {
//    connectionHandler(con, stmt, rs, log);
//  }

  static void connectionHandler(Connection con, Statement stmt, ResultSet rs, Logger log) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        log.info("error", e);
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

  static void showError(String msg, Throwable exc) {
    System.out.println(msg + " hit error: " + exc.getMessage());
  }
}
