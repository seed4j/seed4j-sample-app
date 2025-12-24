package com.seed4j.sample.cucumber;

import com.seed4j.sample.Seed4jsampleApp;
import com.seed4j.sample.cucumber.CucumberConfiguration.CucumberRestClientConfiguration;
import com.seed4j.sample.cucumber.rest.CucumberRestClient;
import com.seed4j.sample.cucumber.rest.CucumberRestTestContext;
import com.seed4j.sample.shared.authentication.infrastructure.primary.TestSecurityConfiguration;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.client.RestTestClient;

@ActiveProfiles("test")
@CucumberContextConfiguration
@AutoConfigureRestTestClient
@SpringBootTest(
  classes = {
    Seed4jsampleApp.class,
    TestSecurityConfiguration.class,
    CucumberAuthenticationConfiguration.class,
    CucumberRestClientConfiguration.class,
  },
  webEnvironment = WebEnvironment.RANDOM_PORT
)
public class CucumberConfiguration {

  private final CucumberRestClient rest;

  CucumberConfiguration(CucumberRestClient rest) {
    this.rest = rest;
  }

  @Before
  public void resetTestContext() {
    CucumberRestTestContext.reset();
  }

  @Before
  public void setupRestClient() {
    rest.setupRestClient();
  }

  @TestConfiguration
  static class CucumberRestClientConfiguration {

    @Bean
    CucumberRestClient cucumberRestClient(RestTestClient rest) {
      return new CucumberRestClient(rest);
    }
  }
}
