package com.darcardona.libraryu.repository;

import org.junit.Before;
import org.junit.Test;

import com.darcardona.libraryu.model.catalog.Category;
import com.darcardona.libraryu.repository.CategoryRepository;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by dar on 11/23/14.
 */
public class CategoryRepositoryTest {

	AtomicLong id;
	CategoryRepository categoryHandler;
	private static final Random RANDOM = new Random();

	@Before
	public void setup() {
		id = new AtomicLong();
		categoryHandler = new CategoryRepository();
	}

	@Test
	public void addCategory() {
		Category newCategory = createCategory();
		categoryHandler.add(newCategory);

		Category categoryFound = categoryHandler.find(newCategory.getId());
		assertNotNull("category added not null", categoryFound);
		assertEquals("category found equals added", newCategory, categoryFound);
	}

	@Test
	public void updateCategory() {
		Category newCategory = createCategory();
		categoryHandler.add(newCategory);

		Category categoryToUpdate = categoryHandler.find(newCategory.getId());
		categoryToUpdate.setName("new name");
		categoryHandler.update(categoryToUpdate);

		Category categoryUpdated = categoryHandler.find(newCategory.getId());

		assertEquals("category name updated", "new name",
				categoryUpdated.getName());
	}

	@Test
	public void removeCategory() {
		Category newCategory = createCategory();
		categoryHandler.add(newCategory);

		categoryHandler.delete(newCategory.getId());

		Category categoryFound = categoryHandler.find(newCategory.getId());
		assertNull("category deleted should be null", categoryFound);
	}

	private Category createCategory() {
		Long currentId = id.incrementAndGet();

		Category newCategory = new Category();
		newCategory.setId(currentId);
		newCategory.setName("Science" + currentId);

		return newCategory;
	}
}
