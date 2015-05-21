package com.darcardona.libraryu.config;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darcardona.libraryu.repository.CategoryRepository;

public class MongoConfigTest {

	@Test
	public void bootstrapAppFromJavaConfig() {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				MongoConfig.class);

		assertThat(context).isNotNull();

		CategoryRepository repository = context
				.getBean(CategoryRepository.class);

		assertThat(repository).isNotNull();
		assertThat(repository.count()).isGreaterThanOrEqualTo(0);
	}
}
