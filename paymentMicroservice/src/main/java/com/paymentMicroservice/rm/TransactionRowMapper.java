package com.paymentMicroservice.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymentMicroservice.domain.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {

	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Transaction t = new Transaction();
		t.setTrans_id(rs.getInt("transId"));
		t.setUserId(rs.getInt("UserId"));
		t.setAccId(rs.getInt("AccId"));
		t.setAppId(rs.getInt("AppId"));
        return t;
		
	}

}
