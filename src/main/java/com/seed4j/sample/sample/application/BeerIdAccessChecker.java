package com.seed4j.sample.sample.application;

import com.seed4j.sample.sample.domain.BeerId;
import com.seed4j.sample.shared.kipe.application.AccessChecker;
import com.seed4j.sample.shared.kipe.application.AccessContext;
import com.seed4j.sample.shared.kipe.application.Seed4jsampleAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerIdAccessChecker implements AccessChecker<BeerId> {

  private final Seed4jsampleAuthorizations authorizations;

  public BeerIdAccessChecker(Seed4jsampleAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerId> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
