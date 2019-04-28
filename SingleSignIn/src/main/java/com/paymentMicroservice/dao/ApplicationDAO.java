package com.paymentMicroservice.dao;

import java.util.List;
import com.paymentMicroservice.domain.Application;

/**
 * @author vijetaagrawal
 *
 */

public interface ApplicationDAO {

	public Application save(Application a, String name, Object attribute); // save the user object
	public void update(Application a); // update the user object
	public void delete(Application a); // delete the user object
	public void delete(Integer ApplicationId); // delete the user by its userId
	public List<Application> findAll(); // find the user by its userId
	public Application findById(Integer ApplicationId); // find the user by its userId
	public List<Application> findByProperty(String propName, Object propValue); // find the user by its property name and its value
}