package com.seed4j.sample.sample.application;

import com.seed4j.sample.sample.domain.beer.BeerToCreate;
import com.seed4j.sample.shared.kipe.application.AccessChecker;
import com.seed4j.sample.shared.kipe.application.AccessContext;
import com.seed4j.sample.shared.kipe.application.Seed4jsampleAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerToCreateAccessChecker implements AccessChecker<BeerToCreate> {

  private final Seed4jsampleAuthorizations authorizations;

  public BeerToCreateAccessChecker(Seed4jsampleAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerToCreate> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
