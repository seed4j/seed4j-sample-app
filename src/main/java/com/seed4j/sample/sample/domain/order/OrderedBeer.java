package com.seed4j.sample.sample.domain.order;

import com.seed4j.sample.sample.domain.Amount;
import com.seed4j.sample.sample.domain.BeerId;
import com.seed4j.sample.shared.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
  public OrderedBeer {
    Assert.notNull("beer", beer);
    Assert.notNull("unitPrice", unitPrice);
  }
}
