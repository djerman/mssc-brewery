package rs.services.mssc_brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rs.services.mssc_brewery.web.model.CustomerDto;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID customrId) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Goran Djermanovic")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting customer ...");
	}

}
