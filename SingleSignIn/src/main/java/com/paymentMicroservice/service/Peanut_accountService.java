package com.paymentMicroservice.service;

import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.domain.Peanut_account;
import com.paymentMicroservice.exception.InsufficientPeanutsException;

public interface Peanut_accountService {
	public Peanut_account createAccount(Peanut_account p, Object attribute);
	
	public void debit(Peanut_account p, Integer UserId) throws InsufficientPeanutsException;
	
	public void credit(Peanut_account p, Application a, Peanut_account m1, Peanut_account m2);
}
