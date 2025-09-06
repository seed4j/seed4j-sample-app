package com.seed4j.sample.sample.domain.beer;

import com.seed4j.sample.sample.domain.BeerId;
import java.util.Optional;

public interface BeersRepository {
  void save(Beer beer);

  Beers catalog();

  Optional<Beer> get(BeerId beer);
}
