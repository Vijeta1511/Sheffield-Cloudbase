package com.paymentMicroservice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paymentMicroservice.config.SpringRootConfig;
import com.paymentMicroservice.dao.UserDAO;
import com.paymentMicroservice.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);

		userDAO.delete(5);
		System.out.println("Data Deleted");

	}

}