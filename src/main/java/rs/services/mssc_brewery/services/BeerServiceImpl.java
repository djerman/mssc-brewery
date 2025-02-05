package rs.services.mssc_brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rs.services.mssc_brewery.web.model.BeerDto;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting beer ...");
	}

}
