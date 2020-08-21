package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        BeerDto foundBeerDto = getBeerById(beerId);

        foundBeerDto.setBeerName(beerDto.getBeerName());
        foundBeerDto.setBeerStyle(beerDto.getBeerStyle());
        foundBeerDto.setUpc(beerDto.getUpc());

        return foundBeerDto;
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("deleting beer with Id: " + beerId);
    }
}
