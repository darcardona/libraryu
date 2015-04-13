package com.darcardona.libraryu.model.dao.catalog.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.darcardona.libraryu.model.dao.BaseMongoDAO;
import com.darcardona.libraryu.model.dao.catalog.Category;
import com.darcardona.libraryu.model.dao.catalog.CategoryDAO;
import com.darcardona.libraryu.model.exceptions.BaseDAOException;
import com.darcardona.libraryu.model.exceptions.DuplicateKeyException;

@Service
public class CategoryDAOImpl extends BaseMongoDAO implements CategoryDAO {

	static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Override
	public Category add(Category categoryToAdd) throws BaseDAOException,
			DuplicateKeyException {
		Category categoryFound = find(categoryToAdd.getId());
		if (categoryFound != null)
			throw new DuplicateKeyException("Category already exists.");
		// categoryToAdd.setCreationDate(new Date());
		this.getMongoTemplate().insert(categoryToAdd);
		log.info("Category created: " + categoryToAdd.toString());
		return categoryToAdd;
	}

	@Override
	public Category find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category find(Category toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public long count() {
		// findAll().size() approach is very inefficient, since it returns the
		// whole documents
		// List<Category> results = mongoTemplate.findAll(Category.class);
		return this.getMongoTemplate().count(null, Category.class);
	}

}