package com.ms.login.persistence;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * Class used for configuration DB-orm-hibernate properties defined by the application file.
 * This file provides all resources needed for a successful execution. 
 * 
 * @author rafamDev
 * 
 */
@Configuration
public class DataSourceConfig {
	
	@Value("${db.port}")
    private int dbPort;
	
	@Value("${db.name}")
    private String dbName;
	
	@Value("${db.ipServer}")
    private String ipServer;
	
	@Value("${db.server}")
    private String dbServer;
	
	@Value("${db.userName}")
    private String userName;
	
	@Value("${db.userPassword}")
    private String userPassword;
	
	@Value("${db.sqlDialect}")
    private String sqlDialect;
	
	@Value("${orm.session.package}")
    private String sessionPackage;

	
	@Bean
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(sessionPackage);
        sessionFactory.setHibernateProperties(getHibernateProperties());
        
        return sessionFactory;
    }
	
	
	@Bean
    DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org." + dbServer + ".Driver");
        dataSource.setUrl("jdbc:" +  dbServer + "://" +  ipServer + ":" + dbPort  + "/" + dbName);
        dataSource.setUsername(userName);
        dataSource.setPassword(userPassword);
        dataSource.setConnectionProperties(getHibernateProperties());
        
        return dataSource;
    }

    private Properties getHibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect." + sqlDialect);
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        
        return properties;
    }
   
}
