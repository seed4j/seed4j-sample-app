package com.seed4j.sample.account.domain;

import com.seed4j.sample.shared.authentication.domain.Role;
import com.seed4j.sample.shared.authentication.domain.Roles;
import com.seed4j.sample.shared.authentication.domain.Username;
import com.seed4j.sample.shared.error.domain.Assert;
import com.seed4j.sample.shared.useridentity.domain.Email;
import com.seed4j.sample.shared.useridentity.domain.Firstname;
import com.seed4j.sample.shared.useridentity.domain.Lastname;
import com.seed4j.sample.shared.useridentity.domain.Name;
import java.util.Collection;
import java.util.stream.Collectors;

public final class Account {

  private final Username username;
  private final Name name;
  private final Email email;
  private final Roles roles;

  private Account(UserBuilder builder) {
    Assert.notNull("username", builder.username);
    Assert.notNull("firstname", builder.firstname);
    Assert.notNull("lastname", builder.lastname);
    Assert.notNull("roles", builder.roles);

    username = builder.username;
    name = new Name(builder.firstname, builder.lastname);
    email = builder.email;
    roles = builder.roles;
  }

  public static AccountUsernameBuilder builder() {
    return new UserBuilder();
  }

  public Username username() {
    return username;
  }

  public Name name() {
    return name;
  }

  public Email email() {
    return email;
  }

  public Roles roles() {
    return roles;
  }

  private static final class UserBuilder
    implements
      AccountUsernameBuilder,
      AccountFirstnameBuilder,
      AccountLastnameBuilder,
      AccountEmailBuilder,
      AccountRolesBuilder,
      AccountOptionalFieldBuilder {

    private Username username;
    private Firstname firstname;
    private Lastname lastname;
    private Email email;
    private Roles roles;

    private UserBuilder() {}

    @Override
    public AccountFirstnameBuilder username(Username username) {
      this.username = username;

      return this;
    }

    @Override
    public AccountLastnameBuilder firstname(Firstname firstname) {
      this.firstname = firstname;

      return this;
    }

    @Override
    public AccountEmailBuilder lastname(Lastname lastname) {
      this.lastname = lastname;

      return this;
    }

    @Override
    public AccountRolesBuilder email(Email email) {
      this.email = email;

      return this;
    }

    @Override
    public AccountOptionalFieldBuilder roles(Roles roles) {
      this.roles = roles;

      return this;
    }

    @Override
    public Account build() {
      return new Account(this);
    }
  }

  public interface AccountUsernameBuilder {
    AccountFirstnameBuilder username(Username username);

    default AccountFirstnameBuilder username(String username) {
      return username(new Username(username));
    }
  }

  public interface AccountFirstnameBuilder {
    AccountLastnameBuilder firstname(Firstname firstname);

    default AccountLastnameBuilder firstname(String firstname) {
      return firstname(new Firstname(firstname));
    }
  }

  public interface AccountLastnameBuilder {
    AccountEmailBuilder lastname(Lastname lastname);

    default AccountEmailBuilder lastname(String lastname) {
      return lastname(new Lastname(lastname));
    }
  }

  public interface AccountEmailBuilder {
    AccountRolesBuilder email(Email email);

    default AccountRolesBuilder email(String email) {
      return email(new Email(email));
    }
  }

  public interface AccountRolesBuilder {
    AccountOptionalFieldBuilder roles(Roles roles);

    default AccountOptionalFieldBuilder roles(Collection<String> roles) {
      Assert.notNull("roles", roles);

      return roles(new Roles(roles.stream().map(Role::from).collect(Collectors.toUnmodifiableSet())));
    }
  }

  public interface AccountOptionalFieldBuilder {
    Account build();
  }
}
