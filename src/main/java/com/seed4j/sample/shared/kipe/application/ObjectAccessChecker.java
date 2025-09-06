package com.seed4j.sample.shared.kipe.application;

import com.seed4j.sample.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ObjectAccessChecker implements AccessChecker<Object> {

  private static final Logger log = LoggerFactory.getLogger(ObjectAccessChecker.class);

  @Override
  @ExcludeFromGeneratedCodeCoverage(reason = "Ignored log conditional")
  public boolean can(AccessContext<Object> access) {
    if (log.isWarnEnabled()) {
      log.warn("No access checker found for {}, using default for action {}", getElementClass(access.element()), access.action());
    }

    return false;
  }

  private String getElementClass(Object item) {
    if (item == null) {
      return "unknown";
    }

    return item.getClass().getName();
  }
}
