package ubc.cpsc304.database;

import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.driver.OracleDriver;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
class DBConnectionUtilTest {
    @Test
    void connection() throws SQLException, InterruptedException {
//        DBConnectionUtil test
//        Connection connection = DBConnectionUtil.getConnection();
//        assertThat(connection).isNotNull();
//
//        DataScource & HikariDataSource test
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(ORACLE_URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(3);
        dataSource.setPoolName("MyPool");
//                DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL, USER_NAME, PASSWORD);
        Connection connection = dataSource.getConnection();
        log.info("connection={}, class={}", connection, connection.getClass());
        log.info("connection={}, class={}", connection, connection.getClass());
        Thread.sleep(1000);
    }
}
