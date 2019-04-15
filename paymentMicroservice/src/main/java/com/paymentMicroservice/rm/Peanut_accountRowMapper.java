package com.paymentMicroservice.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymentMicroservice.domain.Peanut_account;

public class Peanut_accountRowMapper implements RowMapper<Peanut_account> {

	public Peanut_account mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Peanut_account p = new Peanut_account();
		p.setAcc_id(rs.getInt("accId"));
//        u.setName(rs.getString("name"));
//        u.setPhone(rs.getString("phone"));
//        u.setEmail(rs.getString("email"));
//        u.setAddress(rs.getString("address"));
//        u.setLoginName(rs.getString("loginName"));
//        u.setRole(rs.getInt("role"));
//        u.setLoginStatus(rs.getInt("loginStatus"));
        return p;
		
	}

}
