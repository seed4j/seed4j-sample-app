package com.seed4j.sample.sample.domain;

import static org.assertj.core.api.Assertions.*;

import com.seed4j.sample.UnitTest;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@UnitTest
class AmountTest {

  @ParameterizedTest
  @MethodSource("amounts")
  void shouldScaleValue(BigDecimal sourceValue, BigDecimal expectedResult) {
    assertThat(new Amount(sourceValue).get()).isEqualTo(expectedResult);
  }

  static Stream<Arguments> amounts() {
    return Stream.of(
      Arguments.of(new BigDecimal("12.4"), new BigDecimal("12.40")),
      Arguments.of(new BigDecimal("12.455"), new BigDecimal("12.46")),
      Arguments.of(new BigDecimal("12.454"), new BigDecimal("12.45")),
      Arguments.of(new BigDecimal("12.457"), new BigDecimal("12.46"))
    );
  }
}
