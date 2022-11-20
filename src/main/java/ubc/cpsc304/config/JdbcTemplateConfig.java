package ubc.cpsc304.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import ubc.cpsc304.services.ParkService;

import java.sql.Connection;
import java.sql.DriverManager;

import static ubc.cpsc304.database.ConnectionConst.*;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

    private final DataSource dataSource;

    @Bean
    public ParkService parkService() {
        return new ParkService(dataSource);
    }
}