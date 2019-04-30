package com.paymentMicroservice.service;

import java.util.List;

import com.paymentMicroservice.domain.Transaction;

public interface TransactionService {

	public void newTransaction(String AppName, Integer UserId);
	
	public List<Transaction> viewAllTransactions(Integer UserId);
}
