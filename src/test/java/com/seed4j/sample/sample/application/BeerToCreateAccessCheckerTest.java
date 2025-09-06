package com.seed4j.sample.sample.application;

import static com.seed4j.sample.sample.domain.beer.BeersFixture.*;
import static com.seed4j.sample.shared.kipe.application.TestAuthentications.*;
import static org.assertj.core.api.Assertions.*;

import com.seed4j.sample.UnitTest;
import com.seed4j.sample.shared.kipe.application.AccessContext;
import com.seed4j.sample.shared.kipe.application.Seed4jsampleAuthorizations;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerToCreateAccessCheckerTest {

  private static final BeerToCreateAccessChecker checker = new BeerToCreateAccessChecker(
    new Seed4jsampleAuthorizations(List.of(new BeersAccessesConfiguration().beersAccesses()))
  );

  @Test
  void shouldNotAuthorizedUnauthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "unauthorized", beerToCreate()))).isFalse();
  }

  @Test
  void shouldAuthorizedAuthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "create", beerToCreate()))).isTrue();
  }
}
