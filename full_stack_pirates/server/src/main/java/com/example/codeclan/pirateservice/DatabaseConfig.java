package com.example.codeclan.pirateservice;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

public class DatabaseConfig {

    @Configuration
    public class DatabaseConfig {

        @Value("${spring.datasource.url}")
        private String dbUrl;

        @Bean
        public DataSource dataSource(){
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        }
    }

}
