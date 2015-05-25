package com.darcardona.libraryu.config;

import static org.fest.assertions.Assertions.assertThat;

import com.darcardona.libraryu.repository.AbstractIntegrationTestConfig.AbstractRepositoryIntegrationTestConfiguration;
import com.darcardona.libraryu.repository.CategoryRepository;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MongoConfigTest {

  @Test
  public void bootstrapAppFromJavaConfig() {

    ApplicationContext context =
        new AnnotationConfigApplicationContext(AbstractRepositoryIntegrationTestConfiguration.class);

    assertThat(context).isNotNull();

    CategoryRepository repository = context.getBean(CategoryRepository.class);

    assertThat(repository).isNotNull();
    assertThat(repository.count()).isGreaterThanOrEqualTo(0);
  }
}
