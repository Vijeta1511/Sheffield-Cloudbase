package com.paymentMicroservice.service;

import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.domain.Peanut_account;
import com.paymentMicroservice.exception.InsufficientPeanutsException;

public interface Peanut_accountService {
	public Peanut_account createAccount(Peanut_account p, Object attribute);
	
	public Integer balance(Integer UserId);
	
	public void debit(Integer UserId);
	
	public void credit(Integer UserId);
}
