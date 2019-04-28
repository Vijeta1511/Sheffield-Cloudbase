
package com.paymentMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.dao.TransactionDAO;
import com.paymentMicroservice.domain.Transaction;

/**
 * @author vijetaagrawal
 *
 */

@Service
public class TransactionServiceImpl extends BaseDAO implements TransactionService {
	
	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public void newTransaction(Transaction t) {
		transactionDAO.save(t);
	}

	@Override
	public void viewAllTransactions(Integer UserId) {
		// TODO Auto-generated method stub
		
	}

}
