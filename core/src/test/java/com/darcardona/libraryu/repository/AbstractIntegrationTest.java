package com.darcardona.libraryu.repository;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foursquare.fongo.Fongo;
import com.mongodb.Mongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Ignore
public class AbstractIntegrationTest {

	@Configuration
	@EnableMongoRepositories
	@ComponentScan
	static class AbstractRepositoryIntegrationTestConfiguration extends
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

	}
}