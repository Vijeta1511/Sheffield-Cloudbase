package com.paymentMicroservice.test;

import com.paymentMicroservice.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext (SpringRootConfig.class);
		DataSource ds =  ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql= "INSERT INTO user(`name`, `phone_number`, `email_id`, `address`, `user_name`, `password`) VALUES(?,?,?,?,?,?)";
		Object[] param = new Object[] {"Vijeta", "1234567896", "agrawalv71@gmail.com", "lucknow", "v", "v123"};
		jt.update(sql, param);
		System.out.println("--------SQL Executed---------");
	}
}
 