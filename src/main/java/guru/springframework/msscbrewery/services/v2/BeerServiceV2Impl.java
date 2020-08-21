package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyle;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Sarajevsko V2")
                .beerStyle(BeerStyle.LAGER)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Sarajevsko V2")
                .beerStyle(BeerStyle.LAGER)
                .upc(12345L)
                .build();
    }

    @Override
    public BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        return null;
    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}
