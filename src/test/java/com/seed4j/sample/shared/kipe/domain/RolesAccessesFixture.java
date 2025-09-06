package com.seed4j.sample.shared.kipe.domain;

import com.seed4j.sample.shared.authentication.domain.Role;

public final class RolesAccessesFixture {

  private RolesAccessesFixture() {}

  public static RolesAccesses rolesAccesses() {
    // @formatter:off
    return RolesAccesses.builder()
        .role(Role.ADMIN)
          .allAuthorized("read", TestResource.USERS)
          .allAuthorized("read", TestResource.DATA)
          .and()
        .role(Role.USER)
          .allAuthorized("update", TestResource.USERS)
          .specificAuthorized("read", TestResource.USERS)
          .specificAuthorized("delete", TestResource.USERS)
          .and()
        .build();
    // @formatter:on
  }

  public enum TestResource implements Resource {
    USERS("test-users"),
    DATA("test-data");

    private final String key;

    TestResource(String key) {
      this.key = key;
    }

    @Override
    public String key() {
      return key;
    }
  }
}
