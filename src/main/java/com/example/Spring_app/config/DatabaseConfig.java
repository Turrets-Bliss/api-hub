package com.example.Spring_app.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @Primary  // Marks this DataSource as the primary one
    public DataSource dataSourcePostgres() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/spring_app")  // Change to your PostgreSQL URL and database name
                .username("nashtech")  // Replace with your PostgreSQL username
                .password("nashtech")  // Replace with your PostgreSQL password
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
