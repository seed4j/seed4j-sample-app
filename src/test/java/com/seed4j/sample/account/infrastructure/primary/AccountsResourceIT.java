package com.seed4j.sample.account.infrastructure.primary;

import static com.seed4j.sample.account.infrastructure.OAuth2TokenFixture.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.seed4j.sample.IntegrationTest;
import com.seed4j.sample.shared.authentication.infrastructure.primary.WithUnauthenticatedMockUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@IntegrationTest
@AutoConfigureMockMvc
class AccountsResourceIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithUnauthenticatedMockUser
  void shouldNotGetAccountForNotAuthenticatedUser() throws Exception {
    mockMvc.perform(get("/api/authenticated-user-account")).andExpect(status().isUnauthorized());
  }

  @Test
  void shouldGetAuthenticatedUserAccount() throws Exception {
    mockMvc
      .perform(
        get("/api/authenticated-user-account").with(
          oauth2Login()
            .authorities(adminAuthorities())
            .attributes(attributes -> attributes.putAll(testAuthenticationClaims()))
        )
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(jsonPath("$.username").value("user"));
  }
}
