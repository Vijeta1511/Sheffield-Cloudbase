package com.singlesignin.dao;

import java.util.List;
import com.singlesignin.domain.User;

/**
 * This interface contain methods for the basic functionality required during Login and Registration by the user to use database.
 * @author sanika
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
