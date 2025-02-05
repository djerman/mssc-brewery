package rs.services.mssc_brewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import rs.services.mssc_brewery.services.CustomerService;
import rs.services.mssc_brewery.web.model.CustomerDto;

@RequestMapping("/api/v1/customer/")
@RestController
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customerDto) {
		CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer" + savedDto.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleUpdate(@PathVariable UUID customerId, @RequestBody @Valid CustomerDto customerDto) {
		
		customerService.updateCustomer(customerId, customerDto);
	}
	
	@DeleteMapping("{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable UUID customerId) {
		
		customerService.deleteCustomer(customerId);
	}
	
}
