
package com.paymentMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.dao.Peanut_accountDAO;
import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.domain.Peanut_account;
import com.paymentMicroservice.exception.InsufficientPeanutsException;

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
	public void debit(Peanut_account p, Integer UserId) throws InsufficientPeanutsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void credit(Peanut_account p, Application a, Peanut_account m1, Peanut_account m2) {
		// TODO Auto-generated method stub
		
	}
	
}
