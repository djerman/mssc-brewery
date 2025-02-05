package rs.services.mssc_brewery;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rs.services.mssc_brewery.web.model.BeerDto;

@SpringBootTest
class MsscBreweryApplicationTests {

	BeerDto validBeer = BeerDto.builder()
			.id(UUID.randomUUID())
			.beerName("Beer 2")
			.beerStyle("PALE_ALE")
			.upc(123456789012L)
			.build();
	
	@Test
	void contextLoads() {
		System.out.println(validBeer.getBeerName());
	}

	/*@BeforeTestExecution
	void setBeer() {
		validBeer = BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName("Beer 2")
				.beerStyle("PALE_ALE")
				.upc(123456789012L)
				.build();
	}*/
}
