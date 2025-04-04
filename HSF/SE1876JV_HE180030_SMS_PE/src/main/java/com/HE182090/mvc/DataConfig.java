package com.HE182090.mvc;

import com.HE182090.mvc.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan
public class DataConfig implements Constants.DatabaseConfig {
    private final Environment environment;

    public DataConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean(value = "dataSource", name = {"dataSource"})
    DataSource dataSource() {
        Logger.getLogger(getClass().getName()).log(Level.ALL, "data source");
        System.out.println("data source");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(JDBC_DRIVER_CLASSNAME, JDBC_DRIVER_CLASSNAME_DEFAULT));
        dataSource.setUrl(environment.getProperty(JDBC_URL));
        dataSource.setUsername(environment.getProperty(JDBC_USERNAME));
        dataSource.setPassword(environment.getProperty(JDBC_PASSWORD));
        return dataSource;
    }

    @Bean
    HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        System.out.println("getTransactionManager = " + transactionManager == null ? "null" : "getTransactionManager not null");
        return transactionManager;
    }

    @Bean
    LocalSessionFactoryBean sessionFactory() {
        System.out.println("session factory");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{
                "com.HE182090",
                "com.HE182090.entity",
                "com.HE182090.mvc.dao",
                "com.HE182090.mvc.dao.impl",
                "com.HE182090.mvc.service.impl"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(HIBERNATE_DIALECT, environment.getProperty(HIBERNATE_DIALECT));
        properties.setProperty(HIBERNATE_FORMAT_SQL, environment.getProperty(HIBERNATE_FORMAT_SQL));
        properties.setProperty(HIBERNATE_HBM2DDL_AUTO, environment.getProperty(HIBERNATE_HBM2DDL_AUTO));
        properties.setProperty(HIBERNATE_SHOW_SQL, environment.getProperty(HIBERNATE_SHOW_SQL));
        return properties;
    }
}

