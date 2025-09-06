package com.seed4j.sample.sample.infrastructure.primary.beer;

import static com.seed4j.sample.cucumber.rest.CucumberRestAssertions.*;

import com.seed4j.sample.cucumber.rest.CucumberRestTemplate;
import com.seed4j.sample.cucumber.rest.CucumberRestTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class BeersSteps {

  private static final String ADD_BEER_TEMPLATE = """
    {
      "name": "{NAME}",
      "unitPrice": {UNIT_PRICE}
    }
    """;

  private final CucumberRestTemplate rest;

  BeersSteps(CucumberRestTemplate rest) {
    this.rest = rest;
  }

  @When("I add beer to catalog")
  public void addBeerToCatalog(Map<String, String> beer) {
    String payload = ADD_BEER_TEMPLATE.replace("{NAME}", beer.get("Name")).replace("{UNIT_PRICE}", beer.get("Unit price"));

    rest.post("/api/beers", payload);
  }

  @When("I remove the created beer from the catalog")
  public void removeCreatedBeerFromCatalog() {
    rest.delete("/api/beers/" + CucumberRestTestContext.getElement("$.id"));
  }

  @Then("I should have beers catalog")
  public void shouldHaveBeersCatalog(List<Map<String, String>> catalog) {
    rest.get("/api/beers");

    assertThatLastResponse().hasOkStatus().hasElement("$.beers").containingExactly(catalog);
  }
}
