package com.paymentMicroservice.service;

import com.paymentMicroservice.domain.Transaction;

public interface TransactionService {

	public void newTransaction(Transaction t);
	
	public void viewAllTransactions(Integer UserId);
}
