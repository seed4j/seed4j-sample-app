package com.seed4j.sample.shared.kipe.application;

import static org.assertj.core.api.Assertions.*;

import com.seed4j.sample.IntegrationTest;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@IntegrationTest
class AccessCheckerIT {

  @Test
  void canCheckersShouldBeSpringComponents() {
    canCheckers().forEach(this::mustBeSpringBean);
  }

  @SuppressWarnings("rawtypes")
  private Set<Class<? extends AccessChecker>> canCheckers() {
    return new Reflections("com.seed4j.sample").getSubTypesOf(AccessChecker.class);
  }

  private void mustBeSpringBean(@SuppressWarnings("rawtypes") Class<? extends AccessChecker> checker) {
    var annotationsClasses = Stream.of(checker.getAnnotations()).map(Annotation::annotationType).map(Class.class::cast).toList();

    assertThat(annotationsClasses)
      .withFailMessage("AccessCheckers must be spring beans (@Component or @Service) but <%s> isn't", checker.getCanonicalName())
      .containsAnyOf(Component.class, Service.class);
  }
}
