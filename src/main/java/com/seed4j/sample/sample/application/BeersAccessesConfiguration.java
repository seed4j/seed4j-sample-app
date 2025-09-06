package com.seed4j.sample.sample.application;

import com.seed4j.sample.shared.authentication.domain.Role;
import com.seed4j.sample.shared.kipe.domain.RolesAccesses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeersAccessesConfiguration {

  @Bean
  RolesAccesses beersAccesses() {
    return RolesAccesses.builder()
      .role(Role.ADMIN)
      .allAuthorized("create", BeerResource.BEERS)
      .allAuthorized("remove", BeerResource.BEERS)
      .and()
      .build();
  }
}
