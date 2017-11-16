package com.bridgelabz.fundooPay.service.business_service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooPay.bean.ServiceProvider;
import com.bridgelabz.fundooPay.persistence.ServiceProviderDAO;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	ServiceProviderDAO serviceProviderDAO;
	
	public ServiceProvider findServiceProviderById(Long id) {
	
			return serviceProviderDAO.findServiceProviderById(id);
		
	}
}
