package com.darcardona.libraryu.config;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = { "com.darcardona.libraryu" })
@PropertySource("classpath:application.properties")
class ApplicationConfig extends AbstractMongoConfiguration {

	String dbName = "libraryu";

	String dbHost = "localhost";

	int dbPort = 27017;

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		// for a single bd
		// return new MongoClient();

		// for a replica set
		return new MongoClient(Arrays.asList(new ServerAddress(dbHost, dbPort)));
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.darcardona.libraryu.model.dao";
	}
}