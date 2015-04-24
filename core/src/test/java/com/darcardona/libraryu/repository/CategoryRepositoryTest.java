package com.darcardona.libraryu.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcardona.libraryu.domain.Category;
import com.foursquare.fongo.Fongo;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CategoryRepositoryTest {

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb(
			"libraryu-test");

	// nosql-unit requirement
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private CategoryRepository repository;

	@Test
	@ShouldMatchDataSet(location = "/two-category.json")
	public void testInsertCategories() {
		repository.insert(new Category("Art", "South"));
		repository.insert(new Category("Science", "North"));
	}

	@Test
	@UsingDataSet(locations = { "/five-category.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testCountAllPersons() {
		long total = repository.count();

		assertThat(total).isEqualTo(5);
	}

	@Configuration
	@EnableMongoRepositories
	@ComponentScan(basePackageClasses = { CategoryRepository.class })
	@PropertySource("classpath:application.properties")
	static class PersonRepositoryTestConfiguration extends
			AbstractMongoConfiguration {

		@Override
		protected String getDatabaseName() {
			return "libraryu-test";
		}

		@Override
		public Mongo mongo() {
			// uses fongo for in-memory tests
			return new Fongo("mongo-test").getMongo();
		}

		// @Override
		// protected String getMappingBasePackage() {
		// return "com.johnathanmarksmith.mongodb.example.domain";
		// }

	}
}
