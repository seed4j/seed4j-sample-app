package com.seed4j.sample.shared.kipe.domain;

import com.seed4j.sample.shared.error.domain.Assert;

public record Action(String action) {
  public Action {
    Assert.notBlank("action", action);
  }

  @Override
  public String toString() {
    return action();
  }
}
