package rs.services.mssc_brewery.services.v2;

import java.util.UUID;
import rs.services.mssc_brewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {

	BeerDtoV2 getBeerById(UUID beerId);
	
	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);
	
	void updateBeer(UUID beerId, BeerDtoV2 beerDto);
	
	void deleteBeer(UUID beerId);
}
