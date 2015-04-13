package com.darcardona.libraryu.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

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

import com.darcardona.libraryu.model.dao.catalog.Category;
import com.darcardona.libraryu.model.exceptions.BaseDAOException;
import com.darcardona.libraryu.model.exceptions.DuplicateKeyException;
import com.github.fakemongo.Fongo;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CategoryRepositoryTest {

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb(
			"demo-test");

	// nosql-unit requirement
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private CatalogRepository catalogRepository;

	/**
	 * Expected results are in "one-person.json" file
	 * @throws DuplicateKeyException
	 * @throws BaseDAOException
	 */
	@Test
	@ShouldMatchDataSet(location = "/two-category.json")
	public void testInsertCategory() throws BaseDAOException,
			DuplicateKeyException {
		Category category = new Category("Science");
		catalogRepository.addCategory(category);

		category = new Category("Art");
		catalogRepository.addCategory(category);
	}

	/**
	 * Insert data from "five-person.json" and test countAllPersons method
	 */
	// @Test
	// @UsingDataSet(locations = { "/five-person.json" }, loadStrategy =
	// LoadStrategyEnum.CLEAN_INSERT)
	// public void testCountAllPersons() {
	// long total = this.catalogRepository.countAllPersons();
	//
	// assertThat(total).isEqualTo(5);
	// }

	/**
	 * Insert data from "five-person.json" and test countUnderAge method
	 */
	// @Test
	// @UsingDataSet(locations = { "/five-person.json" }, loadStrategy =
	// LoadStrategyEnum.CLEAN_INSERT)
	// public void testCountUnderAge() {
	// long total = this.catalogRepository.countUnderAge();
	//
	// assertThat(total).isEqualTo(3);
	// }

	@Configuration
	@EnableMongoRepositories
	@ComponentScan(basePackages = { "com.darcardona.libraryu.repository" })
	@PropertySource("classpath:application.properties")
	static class PersonRepositoryTestConfiguration extends
			AbstractMongoConfiguration {

		@Override
		protected String getDatabaseName() {
			return "demo-test";
		}

		@Override
		public Mongo mongo() {
			// uses fongo for in-memory tests
			return new Fongo("mongo-test").getMongo();
		}

	}
}
