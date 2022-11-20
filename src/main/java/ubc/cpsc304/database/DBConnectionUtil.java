package ubc.cpsc304.database;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    public static Connection getConnection() {

        try {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(ORACLE_URL);
            dataSource.setUsername(USER_NAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setMaximumPoolSize(1);
            dataSource.setPoolName("MyPool");
                        return dataSource.getConnection();
//            Connection connection = DriverManager.getConnection(ORACLE_URL, USER_NAME, PASSWORD);
//            return connection;

        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            throw new IllegalStateException(e);
        }
    }


}
