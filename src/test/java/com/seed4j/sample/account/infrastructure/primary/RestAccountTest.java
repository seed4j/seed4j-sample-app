package com.seed4j.sample.account.infrastructure.primary;

import static com.seed4j.sample.account.domain.AccountsFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.seed4j.sample.UnitTest;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

@UnitTest
class RestAccountTest {

  private static final ObjectMapper json = new ObjectMapper();

  @Test
  void shouldSerializeToJson() {
    assertThat(json.writeValueAsString(RestAccount.from(account()))).isEqualTo(json());
  }

  private String json() {
    return """
    {\
    "email":"email@company.fr",\
    "name":"Paul DUPOND",\
    "roles":["ROLE_ADMIN"],\
    "username":"user"\
    }\
    """;
  }
}
