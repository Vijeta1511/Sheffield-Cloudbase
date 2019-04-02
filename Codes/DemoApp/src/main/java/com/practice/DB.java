package com.practice;

/*import java.sql.DriverManager;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;
public class DB {

	final static String DB_URL = "jdbc:mysql://localhost:3306/DemoApp";
	final static String USER = "root";
	final static String PASS = "sqlpass1";
	
	public static Connection con() {
		Connection con = null;
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connection established with database");
			
		}catch(Exception e) {
			
			System.out.println("Exception is:");
		}
		return con;
	}
		
		
			
}*/

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

/*
 * Here configuration of Application layer is done (Middleware service component)
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.capp"})
public class DB {
 //TODO: add beans for services , DAO, data sources, email sender etc
	
	@Bean
	public BasicDataSource getDataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/DemoApp");
		ds.setUsername("root");
		ds.setPassword("svds2019");
		ds.setMaxTotal(2); // max 2 connections
		ds.setInitialSize(0);  // initially 1 connection and it can extend to 2 as max limit is 2.
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("SELECT 1");
		ds.setDefaultAutoCommit(true);
		return ds;
		
	}
}

