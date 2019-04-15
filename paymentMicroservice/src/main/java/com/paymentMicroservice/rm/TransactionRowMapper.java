package com.paymentMicroservice.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymentMicroservice.domain.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {

	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Transaction t = new Transaction();
		t.setTrans_id(rs.getInt("transId"));
//        u.setName(rs.getString("name"));
//        u.setPhone(rs.getString("phone"));
//        u.setEmail(rs.getString("email"));
//        u.setAddress(rs.getString("address"));
//        u.setLoginName(rs.getString("loginName"));
//        u.setRole(rs.getInt("role"));
//        u.setLoginStatus(rs.getInt("loginStatus"));
        return t;
		
	}

}
