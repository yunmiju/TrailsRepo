package ubc.cpsc304.database;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import ubc.cpsc304.repository.CountryRepositoryV1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    public static Connection getConnection() {

//        try {
//            // Load the Oracle JDBC driver
//            // Note that the path could change for new drivers
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//
//        } catch (SQLException e) {
//            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//        }
//        try {
//            Connection connection = DriverManager.getConnection(ORACLE_URL, USER_NAME, PASSWORD);
//            connection.setAutoCommit(false);
//            log.info("get connection={}. class={}", connection, connection.getClass());
//            System.out.println("\nConnected to Oracle!");
//            return connection;
//        }
        try {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(ORACLE_URL);
            dataSource.setUsername(USER_NAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setMaximumPoolSize(3);
            dataSource.setPoolName("MyPool");
            return dataSource.getConnection();
        }
        catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            throw new IllegalStateException(e);
        }
    }


}
