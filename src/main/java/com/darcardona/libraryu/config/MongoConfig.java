package com.darcardona.libraryu.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
// @ComponentScan({ "com.darcardona.libraryu" })
@EnableMongoRepositories({ "com.darcardona.libraryu" })
@PropertySource("classpath:mongo.properties")
public class MongoConfig extends AbstractMongoConfiguration {

	@Autowired
	Environment environment;

	@Override
	protected String getDatabaseName() {
		return environment.getProperty("db.name");
	}

	@Override
	public Mongo mongo() throws Exception {

		String dbHost = environment.getProperty("db.host");
		int dbPort = Integer.parseInt(environment.getProperty("db.port"));

		ArrayList<ServerAddress> replicaSet = new ArrayList<ServerAddress>();
		replicaSet.add(new ServerAddress(dbHost, dbPort));

		return new MongoClient(replicaSet);
	}
}
