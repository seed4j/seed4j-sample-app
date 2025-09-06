package com.seed4j.sample.sample.infrastructure.primary.beer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seed4j.sample.sample.domain.Amount;
import com.seed4j.sample.sample.domain.beer.BeerName;
import com.seed4j.sample.sample.domain.beer.BeerToCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(name = "beerToCreate", description = "A beer to create")
class RestBeerToCreate {

  private final String name;
  private final BigDecimal unitPrice;

  RestBeerToCreate(@JsonProperty("name") String name, @JsonProperty("unitPrice") BigDecimal unitPrice) {
    this.name = name;
    this.unitPrice = unitPrice;
  }

  public BeerToCreate toDomain() {
    return new BeerToCreate(new BeerName(getName()), new Amount(getUnitPrice()));
  }

  @NotNull
  @Schema(description = "Name of this beer", requiredMode = RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  @NotNull
  @Schema(description = "Unit price (in euros) of this beer", requiredMode = RequiredMode.REQUIRED)
  public BigDecimal getUnitPrice() {
    return unitPrice;
  }
}
