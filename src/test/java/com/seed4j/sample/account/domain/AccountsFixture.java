package com.seed4j.sample.account.domain;

import static com.seed4j.sample.shared.useridentity.domain.UsersIdentitiesFixture.*;

import com.seed4j.sample.shared.authentication.domain.Role;
import java.util.List;

public final class AccountsFixture {

  private AccountsFixture() {}

  public static Account account() {
    return Account.builder()
      .username(username())
      .firstname(firstname())
      .lastname(lastname())
      .email(email())
      .roles(List.of(Role.ADMIN.key()))
      .build();
  }
}
