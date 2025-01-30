package com.example.Spring_app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.Spring_app.repository.investor", // Ensure this is the correct repository package
        entityManagerFactoryRef = "investorEntityManagerFactory",
        transactionManagerRef = "investorTransactionManager"
)
public class InvestorDataSourceConfig {

    @Bean(name = "investorDataSource")
    @Qualifier("investorDataSource")
    public HikariDataSource investorDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5433/investor_db"); // Replace with your DB URL
        config.setUsername("nashtech"); // Replace with your DB username
        config.setPassword("nashtech"); // Replace with your DB password
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }

    @Bean(name = "investorEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean investorEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("investorDataSource") HikariDataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.Spring_app.entity") // Ensure this is your correct entity package
                .persistenceUnit("investor")
                .build();
    }

    @Bean(name = "investorTransactionManager")
    public PlatformTransactionManager investorTransactionManager(
            @Qualifier("investorEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
