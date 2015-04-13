package com.darcardona.libraryu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darcardona.libraryu.model.dao.catalog.Category;
import com.darcardona.libraryu.model.exceptions.BaseDAOException;
import com.darcardona.libraryu.model.exceptions.DuplicateKeyException;
import com.darcardona.libraryu.repository.CatalogRepository;

public class LibraryUApp {

	static final Logger logger = LoggerFactory.getLogger(LibraryUApp.class);

	public static void main(String[] args) throws BaseDAOException,
			DuplicateKeyException {
		logger.info("LibraryU application");

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfig.class);

		CatalogRepository catalogRepository = context
				.getBean(CatalogRepository.class);

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			catalogRepository.addCategory(new Category("CategoryName"
					+ Math.ceil(Math.random() * 100)));
		}
		long endTime = System.currentTimeMillis();
		logger.info("Load Took " + (endTime - startTime) / 1000 + " seconds");

		startTime = System.currentTimeMillis();
		long count = catalogRepository.countCategories();
		endTime = System.currentTimeMillis();
		logger.info("Count= " + count);
		logger.info("Count All Took " + (endTime - startTime) / 1000
				+ " seconds");
	}
}
