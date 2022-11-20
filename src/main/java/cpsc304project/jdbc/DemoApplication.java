package cpsc304project.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ubc.cpsc304.config.*;

@Slf4j
@Import(JdbcTemplateConfig.class)
@SpringBootApplication(scanBasePackages = "ubc.cpsc304")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
