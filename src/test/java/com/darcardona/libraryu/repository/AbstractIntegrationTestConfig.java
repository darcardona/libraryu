package com.darcardona.libraryu.repository;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AbstractIntegrationTestConfig {

  @Configuration
  @EnableMongoRepositories({"com.darcardona.libraryu"})
  @ComponentScan
  public static class AbstractRepositoryIntegrationTestConfiguration extends
      AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
      return "libraryu-test";
    }

    @Bean
    @Override
    public Mongo mongo() {
      // uses fongo for in-memory tests
      return new Fongo("mongo-test").getMongo();
    }

  }
}
