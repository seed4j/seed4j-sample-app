package com.seed4j.sample.shared.kipe.application;

import com.seed4j.sample.shared.error.domain.Assert;
import org.springframework.security.core.Authentication;

public record ElementAccessContext<T>(Authentication authentication, String action, T element) implements AccessContext<T> {
  public ElementAccessContext {
    Assert.notNull("authentication", authentication);
    Assert.notBlank("action", action);
    Assert.notNull("element", element);
  }
}
