package com.javaArchitect.configs;

import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.core.env.Environment;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import javax.sql.DataSource;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;*/
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScans(value = {@ComponentScan("com.javaArchitect.daos"),
		@ComponentScan("package com.javaArchitect.services"), @ComponentScan("com.javaArchitect.controllers"),
		@ComponentScan("package com.javaArchitect.serviceImpl"), @ComponentScan("package com.javaArchitect.DAOImpls")})
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource =new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	      dataSource.setUrl(env.getProperty("jdbc.url"));
	      dataSource.setUsername(env.getProperty("jdbc.user"));
	      dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean sesionfactory() {
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource(dataSource());
		sessionfactory.setPackagesToScan(new String[] {"com.javaArchitect.models"});
		sessionfactory.setHibernateProperties(hibernateProperties());
		return sessionfactory;
	}
		@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("testMvcHome");
		}
		
		
/*	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
*/	
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	        //properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	        return properties;        
	    }
	 @Bean
	 @Autowired
	 public HibernateTransactionManager transactionmanager(SessionFactory sessionfactory) {
		 
		 HibernateTransactionManager transactionmanager = new HibernateTransactionManager();
		 transactionmanager.setSessionFactory(sessionfactory);
		 return transactionmanager;
	 }
}
