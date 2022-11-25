package ubc.cpsc304;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import ubc.cpsc304.config.*;

@Slf4j
@Import(JdbcTemplateConfig.class)
@SpringBootApplication(scanBasePackages = "ubc.cpsc304.controller")
public class TrailsApplication {
    public static void main(String[] args) {

        SpringApplication.run(TrailsApplication.class, args);
    }
}
