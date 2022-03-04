package perscholascs.mylibrary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//This one refers where your entities and DAO's are
@EnableJpaRepositories(basePackages = "perscholascs.mylibrary.database")
public class DatabaseConfig {
}

