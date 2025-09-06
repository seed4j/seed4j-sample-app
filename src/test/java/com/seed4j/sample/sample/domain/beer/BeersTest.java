package com.seed4j.sample.sample.domain.beer;

import static com.seed4j.sample.sample.domain.BeersIdentityFixture.*;
import static com.seed4j.sample.sample.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.seed4j.sample.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeersTest {

  @Test
  void shouldSortBeersByNames() {
    Beer anteMeridiem = Beer.builder()
      .id(anteMeridiemId())
      .name(new BeerName("Ante Meridiem"))
      .unitPrice(anteMeridiemUnitPrice())
      .sellingState(BeerSellingState.SOLD)
      .build();

    var beers = new Beers(List.of(beer(), anteMeridiem));

    assertThat(beers.get()).usingRecursiveFieldByFieldElementComparator().containsExactly(anteMeridiem, beer());
  }
}
