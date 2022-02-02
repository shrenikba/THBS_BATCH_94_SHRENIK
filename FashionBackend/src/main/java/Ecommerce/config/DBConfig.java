package Ecommerce.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Ecommerce.model.Category;
@Configuration
@ComponentScan(basePackages = {"Ecommerce 	"})
@EnableTransactionManagement
public class DBConfig {

		private String driver="com.mysql.cj.jdbc.Driver";
		private String url="jdbc:mysql://localhost:3306/ecomm";
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
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hdm2dd1.auto","update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(getDataSource());
		
		localFactory.addProperties(hibernateProp);
		
		localFactory.addAnnotatedClass(Category.class);
		
		System.out.println("Session Factory is Created");
		
		return localFactory.buildSessionFactory();
	}
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		System.out.println("Transaction manager object created ");
		return new HibernateTransactionManager(sessionFactory);
		
	}

}
