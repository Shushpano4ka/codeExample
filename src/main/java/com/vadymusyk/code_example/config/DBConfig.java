package com.vadymusyk.code_example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Value("${db.schema.name}")
    private String schema;

    @Value("${db.url.remote}")
    private String remoteUrl;

    @Value("${db.url.local}")
    private String localUrl;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.driver}")
    private String driver;

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(remoteUrl, username, password);
        dataSource.setDriverClassName(driver);
        dataSource.setSchema(schema);
        return dataSource;
    }

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(localUrl, username, password);
        dataSource.setDriverClassName(driver);
        dataSource.setSchema(schema);
        return dataSource;
    }
}
