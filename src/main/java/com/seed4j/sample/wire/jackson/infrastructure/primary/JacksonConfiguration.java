package com.seed4j.sample.wire.jackson.infrastructure.primary;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class JacksonConfiguration {

  @Bean
  Jdk8Module jdk8Module() {
    return new Jdk8Module();
  }
}
