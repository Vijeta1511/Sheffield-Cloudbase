package com.paymentMicroservice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paymentMicroservice.config.SpringRootConfig;
import com.paymentMicroservice.dao.UserDAO;
import com.paymentMicroservice.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setUserId(9);
		u.setName("Sanika_Patil");
		u.setPhone("9890368940_0000");
		u.setAddress("Jalgaon_Sheffield");
		u.setRole(1);
		u.setEmail("S@gmail.com");
		u.setLoginStatus(1);
		userDAO.update(u);
		System.out.println("Data Updated");

	}

}