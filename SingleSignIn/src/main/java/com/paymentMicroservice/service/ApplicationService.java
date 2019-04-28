package com.paymentMicroservice.service;

import com.paymentMicroservice.domain.Application;

public interface ApplicationService {

	public Application registerApplication(Application a, String name, Object attribute);
}
