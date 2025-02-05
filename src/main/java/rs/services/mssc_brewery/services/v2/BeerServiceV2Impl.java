package rs.services.mssc_brewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import rs.services.mssc_brewery.web.model.v2.BeerDtoV2;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2{
	
	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
