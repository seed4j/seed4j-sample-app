package com.seed4j.sample.sample.infrastructure.primary.beer;

import com.seed4j.sample.sample.domain.beer.Beer;
import com.seed4j.sample.shared.error.domain.Assert;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.util.UUID;

@Schema(name = "beer", description = "A beer")
final class RestBeer {

  private final UUID id;
  private final String name;
  private final BigDecimal unitPrice;

  private RestBeer(RestBeerBuilder builder) {
    id = builder.id;
    name = builder.name;
    unitPrice = builder.unitPrice;
  }

  public static RestBeer from(Beer beer) {
    Assert.notNull("beer", beer);

    return new RestBeerBuilder().id(beer.id().get()).name(beer.name().get()).unitPrice(beer.unitPrice().get()).build();
  }

  @Schema(description = "ID of this beer", requiredMode = RequiredMode.REQUIRED)
  public UUID getId() {
    return id;
  }

  @Schema(description = "Name of this beer", requiredMode = RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  @Schema(description = "Unit price (in euro) of this beer", requiredMode = RequiredMode.REQUIRED)
  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  private static final class RestBeerBuilder {

    private UUID id;
    private String name;
    private BigDecimal unitPrice;

    public RestBeerBuilder id(UUID id) {
      this.id = id;

      return this;
    }

    public RestBeerBuilder name(String name) {
      this.name = name;

      return this;
    }

    public RestBeerBuilder unitPrice(BigDecimal unitPrice) {
      this.unitPrice = unitPrice;

      return this;
    }

    public RestBeer build() {
      return new RestBeer(this);
    }
  }
}
