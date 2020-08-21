package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beers")
public class BeerControllerV2 {

    private BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<BeerDtoV2>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> saveBeer(@RequestBody BeerDtoV2 beerDto) {

        BeerDtoV2 savedBeerDto = beerServiceV2.saveBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v2/beers/" + savedBeerDto.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDto) {

        BeerDtoV2 updatedBeerDto = beerServiceV2.updateBeer(beerId ,beerDto);

        return new ResponseEntity<BeerDtoV2>(updatedBeerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> deleteBeer(@PathVariable UUID beerId) {

        beerServiceV2.deleteBeerById(beerId);

        return new ResponseEntity<BeerDtoV2>(HttpStatus.NO_CONTENT);
    }
}
