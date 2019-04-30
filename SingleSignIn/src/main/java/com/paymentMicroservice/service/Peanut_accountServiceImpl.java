
package com.paymentMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.dao.Peanut_accountDAO;
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
		peanut_accountDAO.debitAccount(UserId);
		
	}

	@Override
	public void credit(Integer UserId) { //requires UserID of application Owner
		Integer SignIn = 10;
		Integer Payment = 11;
		peanut_accountDAO.updateSignIn(SignIn);
		peanut_accountDAO.updatePayment(Payment);
		peanut_accountDAO.updateAppOwner(UserId);
			
	}

	@Override
	public Integer balance(Integer UserId) {
		
		Peanut_account p = peanut_accountDAO.findByProperty("userId", UserId);
		return p.getAvailable_peanuts();
		
	}
	
}
