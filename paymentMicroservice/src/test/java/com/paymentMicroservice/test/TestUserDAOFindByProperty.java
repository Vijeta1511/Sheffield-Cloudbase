package com.paymentMicroservice.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paymentMicroservice.config.SpringRootConfig;
import com.paymentMicroservice.dao.UserDAO;
import com.paymentMicroservice.domain.User;

public class TestUserDAOFindByProperty {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		
//		List<User> users = userDAO.findByProperty("Userid", 3);
//		List<User> users = userDAO.findByProperty("name", "Diksha");
		List<User> users = userDAO.findByProperty("name", "Sanika");


		for (User u : users) {
             System.out.println(u.getUserId()+ " " + u.getName()+ " "+ u.getRole());
             
		}


		
		

	}

}