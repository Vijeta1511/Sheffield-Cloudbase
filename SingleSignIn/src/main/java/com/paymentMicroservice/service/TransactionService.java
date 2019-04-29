package com.paymentMicroservice.service;

import java.util.List;

import com.paymentMicroservice.domain.Transaction;

public interface TransactionService {

	public void newTransaction(Transaction t);
	
	public List viewAllTransactions(Integer UserId);
}
