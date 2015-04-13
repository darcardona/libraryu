package com.darcardona.libraryu.dao.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.darcardona.libraryu.model.dao.catalog.Category;
import com.darcardona.libraryu.model.dao.catalog.CategoryDAO;
import com.darcardona.libraryu.model.dao.catalog.impl.CategoryDAOImpl;
import com.darcardona.libraryu.model.exceptions.BaseDAOException;
import com.darcardona.libraryu.model.exceptions.DuplicateKeyException;

/**
 * Created by dar on 11/23/14.
 */
public class CategoryDAOTest {

	CategoryDAO categoryDAO;

	@Before
	public void setup() {
		categoryDAO = new CategoryDAOImpl();
	}

	@Test
	public void addCategory() throws BaseDAOException, DuplicateKeyException {
		// add
		Category newCategory = createCategory("Science");
		categoryDAO.add(newCategory);

		// find
		Category categoryFound = categoryDAO.find(newCategory.getId());

		// validate
		assertNotNull("category added not null", categoryFound);
		assertEquals("category found equals added", newCategory, categoryFound);
		// assertNotNull("category creationDate null",
		// categoryFound.getCreationDate());
	}

	@Test
	public void updateCategory() throws BaseDAOException, DuplicateKeyException {
		// add
		Category newCategory = createCategory("art");
		categoryDAO.add(newCategory);

		// update
		Category categoryToUpdate = categoryDAO.find(newCategory.getId());
		categoryToUpdate.setName(newCategory.getName() + "Updated");
		categoryDAO.update(categoryToUpdate);

		// find
		Category categoryUpdated = categoryDAO.find(newCategory.getId());

		// validate
		assertEquals("category name updated", "new name",
				categoryUpdated.getName());
	}

	@Test
	public void removeCategory() throws BaseDAOException, DuplicateKeyException {
		// add
		Category newCategory = createCategory("religion");
		categoryDAO.add(newCategory);

		// delete
		categoryDAO.delete(newCategory.getId());

		// find
		Category categoryFound = categoryDAO.find(newCategory.getId());

		// validate
		assertNull("category deleted should be null", categoryFound);
	}

	private Category createCategory(String categoryName) {
		Category newCategory = new Category();
		newCategory.setName(categoryName);
		return newCategory;
	}
}
