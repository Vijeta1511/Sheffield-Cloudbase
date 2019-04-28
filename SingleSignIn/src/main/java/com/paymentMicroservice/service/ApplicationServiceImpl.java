
package com.paymentMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.ApplicationDAO;
import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.domain.Application;

/**
 * @author vijetaagrawal
 *
 */

@Service
public class ApplicationServiceImpl extends BaseDAO implements ApplicationService {

	@Autowired
	private ApplicationDAO applicationDAO;
	@Override
	public Application registerApplication(Application a, String name, Object attribute) {
		a = applicationDAO.save(a, name, attribute);
		return a;
	}
	
	
}
