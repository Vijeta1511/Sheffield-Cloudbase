package com.paymentMicroservice.dao;

import java.util.List;
import com.paymentMicroservice.domain.Transaction;

/**
 * @author vijetaagrawal
 *
 */

public interface TransactionDAO {

	public void save(Transaction t, Integer acc_id, Integer app_id, Integer UserId, String AppName); // save the user object
	public void update(Transaction t); // update the user object
	public void delete(Transaction t); // delete the user object
	public void delete(Integer trans_id); // delete the user by its userId
	public Transaction findById(Integer trans_id); // find the user by its userId
	public List<Transaction> findAll(); // find the user by its userId
	public List<Transaction> findByProperty(String propName, Object propValue); // find the user by its property name and its value
}