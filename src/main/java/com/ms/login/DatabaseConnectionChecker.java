package com.ms.login;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionChecker implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;
    
    private static Logger LOG = LoggerFactory.getLogger(DatabaseConnectionChecker.class);

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            LOG.info("Successful data base connection.");
        } catch (SQLException e) {
            LOG.error("Error during data base connection: {}" , e.getMessage());
        }
    }
}