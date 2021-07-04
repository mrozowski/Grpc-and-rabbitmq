package com.mrozowski.reporter.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Datasource {

  @Bean
  @ConfigurationProperties("reporter.datasource")
  public HikariDataSource hikariDataSource() {
    return DataSourceBuilder
        .create()
        .type(HikariDataSource.class)
        .build();
  }
}
