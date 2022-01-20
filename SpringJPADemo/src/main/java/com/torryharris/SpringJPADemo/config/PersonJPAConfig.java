package com.torryharris.SpringJPADemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.torryharris.SpringJPADemo"})
@EnableTransactionManagement
public class PersonJPAConfig {
		
	
	    private String driver="com.mysql.cj.jdbc.Driver";
		private String url="jdbc:mysql://localhost:3306/bank";
		private String userName="root";
		private String password="root";
		
		 
		@Bean
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource =new DriverManagerDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(userName);
			dataSource.setPassword(password);
			
			return dataSource;
		}
		
		
		public Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			return properties;
		
		}
		
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());
		em.setPackagesToScan(new String[] {"com.torryharris.SpringJPADemo.model"});

		JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendor);
		em.setJpaProperties(getHibernateProperties());
		return em;
		}

		@Bean
		public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
		}
	}
	
	

