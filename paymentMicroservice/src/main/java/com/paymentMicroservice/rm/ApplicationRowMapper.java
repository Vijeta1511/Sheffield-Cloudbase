package com.paymentMicroservice.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymentMicroservice.domain.Application;

public class ApplicationRowMapper implements RowMapper<Application> {

	public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Application a = new Application();
		a.setApp_id(rs.getInt("appId"));
        a.setName(rs.getString("name"));
//        u.setPhone(rs.getString("phone"));
//        u.setEmail(rs.getString("email"));
//        u.setAddress(rs.getString("address"));
//        u.setLoginName(rs.getString("loginName"));
//        u.setRole(rs.getInt("role"));
//        u.setLoginStatus(rs.getInt("loginStatus"));
        return a;
		
	}

}
