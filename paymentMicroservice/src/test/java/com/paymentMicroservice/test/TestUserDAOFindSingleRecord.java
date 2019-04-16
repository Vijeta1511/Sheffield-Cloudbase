package com.paymentMicroservice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paymentMicroservice.config.SpringRootConfig;
import com.paymentMicroservice.dao.UserDAO;
import com.paymentMicroservice.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);

		User u = userDAO.findById(10);
		System.out.println("User Detail");
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getPhone());
		System.out.println(u.getLoginName());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getRole());
		
		

	}

}