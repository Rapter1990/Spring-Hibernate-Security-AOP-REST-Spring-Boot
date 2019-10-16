package com.security.config;

import java.beans.PropertyVetoException;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.security")
@PropertySource("classpath:resources/application.properties")
public class DemoAppConfig {

	@Autowired
	private Environment environment;
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(packagesToScan());
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

	@Bean
	public ComboPooledDataSource getDataSource() throws PropertyVetoException {
	    ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	    dataSource.setDriverClass(environment.getRequiredProperty("database.driverClass"));
	    dataSource.setJdbcUrl(environment.getRequiredProperty("database.url"));
	    dataSource.setUser(environment.getRequiredProperty("database.username"));
	    dataSource.setPassword(environment.getRequiredProperty("database.password"));
	    dataSource.setAcquireIncrement(getIntProperty("connection.acquireIncrement"));
	    dataSource.setIdleConnectionTestPeriod(getIntProperty("connection.idle_test_period"));
	    dataSource.setMinPoolSize(getIntProperty("connection.minPoolSize"));
	    dataSource.setMaxPoolSize(getIntProperty("connection.maxPoolSize"));
	    dataSource.setMaxIdleTime(getIntProperty("connection.maxIdleTime"));
	
	    return dataSource;
	}

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        //properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	private int getIntProperty(String propName) {
		
		String propVal = environment.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	protected String[] packagesToScan() {
        return new String[]{
            "com.security"
        };
    }
	
}









