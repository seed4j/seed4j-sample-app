package com.seed4j.sample.shared.pagination.domain;

import com.seed4j.sample.shared.pagination.domain.Seed4jsamplePage.Seed4jsamplePageBuilder;
import java.util.List;

public final class Seed4jsamplePagesFixture {

  private Seed4jsamplePagesFixture() {}

  public static Seed4jsamplePage<String> page() {
    return pageBuilder().build();
  }

  public static Seed4jsamplePageBuilder<String> pageBuilder() {
    return Seed4jsamplePage.builder(List.of("test")).currentPage(2).pageSize(10).totalElementsCount(21);
  }
}
