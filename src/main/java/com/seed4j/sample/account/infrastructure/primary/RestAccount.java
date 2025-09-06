package com.seed4j.sample.account.infrastructure.primary;

import com.seed4j.sample.account.domain.Account;
import com.seed4j.sample.shared.authentication.domain.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.Collection;

@Schema(name = "user", description = "Information for an user")
final class RestAccount {

  private final String username;
  private final String name;
  private final String email;
  private final Collection<String> roles;

  private RestAccount(RestAccountBuilder builder) {
    username = builder.username;
    name = builder.name;
    email = builder.email;
    roles = builder.roles;
  }

  static RestAccount from(Account account) {
    return new RestAccountBuilder()
      .username(account.username().get())
      .name(account.name().get())
      .email(account.email().get())
      .roles(account.roles().get().stream().map(Role::key).toList())
      .build();
  }

  @Schema(description = "Username of this user", requiredMode = RequiredMode.REQUIRED)
  public String getUsername() {
    return username;
  }

  @Schema(description = "Fullname (Firstname LASTNAME) of this user", requiredMode = RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  @Schema(description = "Email of this user", requiredMode = RequiredMode.REQUIRED)
  public String getEmail() {
    return email;
  }

  @Schema(description = "Roles of this user")
  public Collection<String> getRoles() {
    return roles;
  }

  private static final class RestAccountBuilder {

    private String username;
    private String name;
    private String email;
    private Collection<String> roles;

    public RestAccountBuilder username(String username) {
      this.username = username;

      return this;
    }

    public RestAccountBuilder name(String name) {
      this.name = name;

      return this;
    }

    public RestAccountBuilder email(String email) {
      this.email = email;

      return this;
    }

    public RestAccountBuilder roles(Collection<String> roles) {
      this.roles = roles;

      return this;
    }

    public RestAccount build() {
      return new RestAccount(this);
    }
  }
}
