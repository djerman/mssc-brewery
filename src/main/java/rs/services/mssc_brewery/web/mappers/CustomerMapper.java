package rs.services.mssc_brewery.web.mappers;

import org.mapstruct.Mapper;

import rs.services.mssc_brewery.domain.Customer;
import rs.services.mssc_brewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);
    
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
