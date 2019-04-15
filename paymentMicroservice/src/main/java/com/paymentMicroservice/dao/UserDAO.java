package com.paymentMicroservice.dao;

import java.util.List;
import com.paymentMicroservice.domain.User;

/**
 * @author vijetaagrawal
 *
 */

public interface UserDAO {

	public void save(User u); // save the user object
	public void update(User u); // update the user object
	public void delete(User u); // delete the user object
	public void delete(Integer userId); // delete the user by its userId
	public User findById(Integer userId); // find the user by its userId
	public List<User> findByProperty(String propName, Object propValue); // find the user by its property name and its value
}