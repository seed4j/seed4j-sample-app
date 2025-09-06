package com.seed4j.sample;

import com.seed4j.sample.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ExcludeFromGeneratedCodeCoverage(reason = "Not testing logs")
public class Seed4jsampleApp {

  private static final Logger log = LoggerFactory.getLogger(Seed4jsampleApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(Seed4jsampleApp.class, args).getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}
