package rs.services.mssc_brewery.web.mappers;

import org.mapstruct.Mapper;

import rs.services.mssc_brewery.domain.Beer;
import rs.services.mssc_brewery.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    
    Beer beerDtoToBeer(BeerDto beerDto);
    
}
