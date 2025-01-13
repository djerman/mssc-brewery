package rs.services.mssc_brewery.services;

import java.util.UUID;

import rs.services.mssc_brewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customrId);
}
