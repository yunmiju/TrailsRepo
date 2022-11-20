//package ubc.cpsc304.database;
//
//import lombok.extern.slf4j.Slf4j;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import static ubc.cpsc304.database.ConnectionConst.*;
//
//@Slf4j
//public class DBConnectionUtil {
//
//    public static Connection getConnection() {
//        try {
//            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//            Connection connection = DriverManager.getConnection(ORACLE_URL, USER_NAME, PASSWORD);
//            log.info("get connection={}, class={}", connection, connection.getClass());
//            return connection;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }
////        try {
////            // Load the Oracle JDBC driver
////            // Note that the path could change for new drivers
////            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
////        } catch (SQLException e) {
////            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
////        }
////        try {
////            Connection connection = DriverManager.getConnection(ORACLE_URL, USER_NAME, PASSWORD);
////            connection.setAutoCommit(false);
////            log.info("get connection={}. class={}", connection, connection.getClass());
////            System.out.println("\nConnected to Oracle!");
////            return connection;
////        } catch (SQLException e) {
////            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
////            throw new IllegalStateException(e);
////        }
////    }
//}
