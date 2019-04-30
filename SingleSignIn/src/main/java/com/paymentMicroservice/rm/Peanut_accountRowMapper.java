package com.paymentMicroservice.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymentMicroservice.domain.Peanut_account;

public class Peanut_accountRowMapper implements RowMapper<Peanut_account> {

	public Peanut_account mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Peanut_account p = new Peanut_account();
		p.setAcc_id(rs.getInt("acc_id"));
		p.setAvailable_peanuts(rs.getInt("available_peanuts"));
		p.setUserId(rs.getInt("userId"));
        return p;
		
	}

}
