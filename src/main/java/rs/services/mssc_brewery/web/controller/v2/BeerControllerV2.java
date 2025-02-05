package rs.services.mssc_brewery.web.controller.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import jakarta.validation.constraints.NotNull;
import rs.services.mssc_brewery.services.v2.BeerServiceV2;
import rs.services.mssc_brewery.web.model.v2.BeerDtoV2;

@Validated
@RequestMapping("/api/v2/beer/")
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerService;
	
	public BeerControllerV2(BeerServiceV2 beerService) {
		this.beerService = beerService;
	}
	
	@GetMapping({"{beerId}"})
	public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
		
		BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		//TO DO add host name to URL
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
		
		beerService.updateBeer(beerId, beerDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		
		beerService.deleteBeer(beerId);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e){
	    List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
	    
	    e.getConstraintViolations().forEach(constraintViolations -> {
		errors.add(constraintViolations.getPropertyPath() + " : " + constraintViolations.getMessage());
	    });
	    
	    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
