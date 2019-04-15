package com.paymentMicroservice.dao;

import java.util.List;
import com.paymentMicroservice.domain.Transaction;

/**
 * @author vijetaagrawal
 *
 */

public interface TransactionDAO {

	public void save(Transaction t); // save the user object
	public void update(Transaction t); // update the user object
	public void delete(Transaction t); // delete the user object
	public void delete(Integer TransactionId); // delete the user by its userId
	public Transaction findById(Integer TransactionId); // find the user by its userId
	public List<Transaction> findByProperty(String propName, Object propValue); // find the user by its property name and its value
}