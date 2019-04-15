package com.paymentMicroservice.dao;

import java.util.List;
import com.paymentMicroservice.domain.Peanut_account;

/**
 * @author vijetaagrawal
 *
 */

public interface Peanut_accountDAO {

	public void save(Peanut_account p); // save the user object
	public void update(Peanut_account p); // update the user object
	public void delete(Peanut_account p); // delete the user object
	public void delete(Integer Peanut_accountId); // delete the user by its userId
	public Peanut_account findById(Integer Peanut_accountId); // find the user by its userId
	public List<Peanut_account> findByProperty(String propName, Object propValue); // find the user by its property name and its value
}