package com.bridgelabz.fundooPay.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooPay.bean.ServiceProvider;

@Repository
public interface ServiceProviderDAO extends CrudRepository<ServiceProvider,Long> {
	
	ServiceProvider findServiceProviderById(Long id);
}
