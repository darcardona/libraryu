package com.darcardona.libraryu.config;

import java.util.ArrayList;

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
@ComponentScan(basePackageClasses = { LibraryuApp.class })
@PropertySource("classpath:application.properties")
public class AppConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "libraryu";
	}

	@Override
	public Mongo mongo() throws Exception {

		ArrayList<ServerAddress> replicaSet = new ArrayList<ServerAddress>();
		replicaSet.add(new ServerAddress("127.0.0.1", 27017));
		replicaSet.add(new ServerAddress("127.0.0.1", 27027));
		replicaSet.add(new ServerAddress("127.0.0.1", 27037));

		return new MongoClient(replicaSet);
	}

}
