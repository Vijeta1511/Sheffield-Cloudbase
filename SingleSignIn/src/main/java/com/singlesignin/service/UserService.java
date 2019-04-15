package com.singlesignin.service;

import com.singlesignin.domain.User;
import com.singlesignin.exception.UserBlockedException;

/**
 * All business logic related to User (registration and login) is provided here.  
 * It takes help from DAO interface to complete the business logic.
 * @author sanika
 *
 */

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	/**
	 * The method handles the user registration task.
	 * @param u User object.
	 */
			
	public void register(User u);
	
	/**
	 * The method handles login operation(authentication) using given credentials.
	 * It returns User object when success and null when failed.
	 * When user is blocked, the exception will be thrown.
	 * @param loginName Username of the user
	 * @param password  Password of the user
	 * @throws UserBlockedException when user account is blocked
	 * @return
	 */
	public User login(String loginName, String password) throws UserBlockedException;

}
