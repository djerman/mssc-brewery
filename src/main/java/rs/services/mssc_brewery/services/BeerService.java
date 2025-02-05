package rs.services.mssc_brewery.services;

import java.util.UUID;

import rs.services.mssc_brewery.web.model.BeerDto;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
