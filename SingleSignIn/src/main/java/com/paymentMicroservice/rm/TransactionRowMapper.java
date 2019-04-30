package com.paymentMicroservice.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymentMicroservice.domain.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {

	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Transaction t = new Transaction();
		t.setTrans_id(rs.getInt("trans_id"));
		t.setUserId(rs.getInt("userId"));
		t.setAccId(rs.getInt("accId"));
		t.setAppId(rs.getInt("appId"));
		t.setApp_name(rs.getString("app_name"));

        return t;
		
	}

}
