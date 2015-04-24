package com.darcardona.libraryu.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.darcardona.libraryu.domain.Category;

@Repository
public class CategoryRepository {

	static final Logger logger = LoggerFactory
			.getLogger(CategoryRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public long count() {
		long total = this.mongoTemplate.count(null, Category.class);
		logger.info("Total number in database: {}", total);

		return total;
	}

	public void insert(Category category) {
		mongoTemplate.insert(category);
	}
}
