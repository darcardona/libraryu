package com.darcardona.libraryu.repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.darcardona.libraryu.model.dao.catalog.Category;
import com.darcardona.libraryu.model.dao.catalog.CategoryDAO;
import com.darcardona.libraryu.model.exceptions.BaseDAOException;
import com.darcardona.libraryu.model.exceptions.DuplicateKeyException;

/**
 * Created by dar on 11/22/14.
 */
@Repository
public class CatalogRepository {

	static final Logger logger = LoggerFactory
			.getLogger(CatalogRepository.class);

	@Autowired
	CategoryDAO categoryDAO;

	public Category addCategory(Category category) throws BaseDAOException,
			DuplicateKeyException {
		return categoryDAO.add(category);
	}

	public long countCategories() {
		return categoryDAO.count();
	}

	@PostConstruct
	public void init() {
		logger.info("Initializing bean with JSR250 @PostConstruct");
	}

	@PreDestroy
	public void destroy() {
		logger.info("Destroying bean with JSR250 @PreDestroy");
	}
}