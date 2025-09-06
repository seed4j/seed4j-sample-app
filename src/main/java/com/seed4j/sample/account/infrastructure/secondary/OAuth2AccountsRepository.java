package com.seed4j.sample.account.infrastructure.secondary;

import com.seed4j.sample.account.domain.Account;
import com.seed4j.sample.account.domain.AccountsRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
class OAuth2AccountsRepository implements AccountsRepository {

  private final OAuth2AuthenticationReader oAuth2Reader;

  public OAuth2AccountsRepository(OAuth2AuthenticationReader oAuth2Reader) {
    this.oAuth2Reader = oAuth2Reader;
  }

  @Override
  public Optional<Account> authenticatedUserAccount() {
    return oAuth2Reader.authenticatedUserAccount();
  }
}
