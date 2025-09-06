package com.seed4j.sample.sample.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;

import com.seed4j.sample.JsonHelper;
import com.seed4j.sample.UnitTest;
import com.seed4j.sample.sample.domain.beer.Beers;
import com.seed4j.sample.sample.domain.beer.BeersFixture;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeersTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestBeers.from(new Beers(List.of(BeersFixture.beer()))))).isEqualTo(json());
  }

  private String json() {
    return "{\"beers\":[" + RestBeerTest.json() + "]}";
  }
}
