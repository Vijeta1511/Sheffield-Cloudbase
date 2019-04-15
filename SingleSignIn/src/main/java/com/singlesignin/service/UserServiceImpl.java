package com.singlesignin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.singlesignin.dao.BaseDAO;
import com.singlesignin.dao.UserDAO;
import com.singlesignin.domain.User;
import com.singlesignin.exception.UserBlockedException;
import com.singlesignin.rm.UserRowMapper;
import com.singlesignin.security.EncryptDecrypt;
 
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;  // dependency injection by using autowired annotation
	
	public void register(User u) {
		userDAO.save(u);
		
	}
	
	/**
	  * This method handles login operation (authentication) using given credentials
	  * When successfully logged in , it return User object else null
	  * When user account is blocked, an exception will be thrown by this method.
	  */

	public User login(String loginName, String password) throws UserBlockedException {
		Map m = new HashMap();
		String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName, password"
                + " FROM user WHERE loginName=:ln AND password=:pw";
		
		EncryptDecrypt e = new EncryptDecrypt();
	        try {
	        	/*
	        	 * Encrypt the password and then check whether for authentication
	        	 */
	        	String encryptPassword= e.encrypt(password, "secret");
				String decryptPassword= e.decrypt(encryptPassword, "secret");			
				m.put("pw", encryptPassword);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		m.put("ln", loginName);
		try{
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
			}
			else {
				return u;
			}
		}catch(EmptyResultDataAccessException ex) {
			return null;	
		}
		
	}
	
}
