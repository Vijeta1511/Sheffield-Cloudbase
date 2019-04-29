
package com.paymentMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.dao.Peanut_accountDAO;
import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.domain.Peanut_account;
import com.paymentMicroservice.exception.InsufficientPeanutsException;
import com.paymentMicroservice.rm.Peanut_accountRowMapper;
import com.paymentMicroservice.rm.TransactionRowMapper;

/**
 * @author vijetaagrawal
 *
 */

@Service
public class Peanut_accountServiceImpl extends BaseDAO implements Peanut_accountService {
	
	@Autowired
	private Peanut_accountDAO peanut_accountDAO;

	@Override
	public Peanut_account createAccount(Peanut_account p, Object attribute) {
		 p = peanut_accountDAO.save(p, attribute);
		 return p;
	}

	@Override
	public void debit(Integer UserId){
		
		String sql = ("UPDATE peanut_account"
				+ " SET available_peanuts = available_peanuts - 5"
				+ "WHERE userId =?");
        getJdbcTemplate().query(sql, new Peanut_accountRowMapper(), UserId);
		
	}

	@Override
	public void credit(Integer UserId) { //requires UserID of application Owner
		Integer SignIn = 5;
		Integer Payment = 3;
		String sql = ("UPDATE peanut_account"
				+ " SET available_peanuts = available_peanuts + 3"
				+ "WHERE userId =?"
				+ "UNION UPDATE peanut_account"
				+ "SET available_peanuts = available_peanuts + 1"
				+ "WHERE userId =?"
				+ "UNION UPDATE peanut_account"
				+ "SET available_peanuts = available_peanuts + 1"
				+ "WHERE userId =?");
        getJdbcTemplate().query(sql, new Peanut_accountRowMapper(), UserId, SignIn, Payment);
			
	}

	@Override
	public Integer balance(Integer UserId) {
		String sql = "SELECT acc_id, available_peanuts FROM peanut_account WHERE userId=?";
		
		Peanut_account p = getJdbcTemplate().queryForObject(sql, new Peanut_accountRowMapper(), UserId);
		Integer balance = p.getAvailable_peanuts();
		return balance;
		
	}
	
}
