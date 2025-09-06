package com.seed4j.sample.sample.domain.beer;

import com.seed4j.sample.sample.domain.Amount;
import com.seed4j.sample.sample.domain.BeerId;
import com.seed4j.sample.shared.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
  public BeerToCreate {
    Assert.notNull("name", name);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Beer create() {
    return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
  }
}
