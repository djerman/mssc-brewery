package rs.services.mssc_brewery.services;

import java.util.UUID;

import rs.services.mssc_brewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);
	
	CustomerDto saveNewCustomer(CustomerDto customerDto);
	
	void updateCustomer(UUID customerId, CustomerDto customerDto);
	
	void deleteCustomer(UUID customerId);
}
