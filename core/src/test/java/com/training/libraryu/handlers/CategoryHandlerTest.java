package com.training.libraryu.handlers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.dar.training.libraryu.handlers.CategoryHandler;
import com.dar.training.libraryu.model.catalog.Category;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by dar on 11/23/14.
 */
public class CategoryHandlerTest {

	AtomicLong id;
	CategoryHandler categoryHandler;
	private static final Random RANDOM = new Random();

	@Before
	public void setup() {
		id = new AtomicLong();
		categoryHandler = new CategoryHandler();
	}

	@Test
	public void addCategory() {
		Category newCategory = createCategory();
		categoryHandler.insert(newCategory);

		Category categoryFound = categoryHandler.findById(newCategory.getId());
		assertNotNull("category added not null", categoryFound);
		assertEquals("category found equals added", newCategory, categoryFound);
	}

	@Test @Ignore
	public void getAllCategoryRegardlessOfCurrentState() {
		for (int i = 0; i < 10; i++) {
			Category category = createCategoryWithRandomState();
			// System.out.println("State: " + handlers.getState());
			categoryHandler.insert(category);
		}

		int all = categoryHandler.findAll().size();
		int allActive = categoryHandler.findAllActives().size();

		assertTrue("active greater than zero", allActive > 0);
		assertFalse("active and inactive", all == allActive);
	}

	@Test
	public void updateCategory() {
		Category newCategory = createCategory();
		categoryHandler.insert(newCategory);

		Category categoryToUpdate = categoryHandler.findById(newCategory
				.getId());
		categoryToUpdate.setName("new name");
		categoryHandler.update(categoryToUpdate);

		Category categoryUpdated = categoryHandler
				.findById(newCategory.getId());

		assertEquals("category name updated", "new name",
				categoryUpdated.getName());
	}

	@Test
	public void removeCategory() {
		Category newCategory = createCategory();
		categoryHandler.insert(newCategory);

		categoryHandler.delete(newCategory);

		Category categoryFound = categoryHandler.findById(newCategory.getId());
		assertNull("category deleted should be null", categoryFound);
	}

	private Category createCategory() {
		Long currentId = id.incrementAndGet();

		Category newCategory = new Category();
		newCategory.setId(currentId);
		newCategory.setName("Science" + currentId);

		return newCategory;
	}

	private Category createCategoryWithRandomState() {
		Category newCategory = createCategory();
		newCategory.setState(randomState());
		return newCategory;
	}

	public static String randomState() {
		String[] states = { "ACTIVE", "INACTIVE" };
		return states[RANDOM.nextInt(states.length)];
	}
}
