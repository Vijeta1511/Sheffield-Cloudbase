package com.singlesignin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.singlesignin.domain.User;
import com.singlesignin.rm.UserRowMapper;
import com.singlesignin.security.EncryptDecrypt;

/**
 * This is the class which implements UserDAO and handles the database , so it is annotated with @Repository
 * @author sanika
 *
 */

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {
	
	public void save(User u) {
		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
                + " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        
        EncryptDecrypt e = new EncryptDecrypt();
        try {
        	/*
        	 * Encrypt the password before storing it in database
        	 */
        	
        	String encryptPassword= e.encrypt(u.getPassword(), "secret");
        	//System.out.println("encryptPassword: "+ encryptPassword);
        	m.put("password", encryptPassword);   	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
        /*
         * keyholder object will bind the value which is auto incremented and generated by the database.
         * The auto incremented value after insert will be available in this object.
         */
        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserId(userId);
	}

	public void update(User u) {
		String sql = "UPDATE user "
                + " SET name=:name,"
                + " phone=:phone, "
                + " email=:email,"
                + " address=:address,"
                + " role=:role,"
                + " loginStatus=:loginStatus "
                + " WHERE userId=:userId";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());       
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());
        getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	public void delete(User u) {
		this.delete(u.getUserId());
		
	}

	public User findById(Integer userId) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
				+ " FROM user WHERE userId=?";
		User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
		return u;
		
		}

	public List<User> findByProperty(String propName, Object propValue) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
				+ " FROM user WHERE "+propName+"=?";
		return getJdbcTemplate().query(sql, new UserRowMapper(),propValue);
	}

	public void delete(Integer userId) {
		String sql="DELETE FROM user WHERE userId=?";
        getJdbcTemplate().update(sql, userId);
		
	}

}
