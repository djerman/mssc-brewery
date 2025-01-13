package rs.services.mssc_brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import rs.services.mssc_brewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID customrId) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Goran DJermanovic")
				.build();
	}

}
