package com.dar.training.libraryu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.dar.training.libraryu.model.catalog.Category;
import static com.dar.training.libraryu.repository.util.CategoryPredicate.*;

/**
 * Created by dar on 11/22/14.
 */
@Component
public class CategoryRepository implements LibraryURepository<Category> {

	private AtomicLong currentId = new AtomicLong();
	private ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();

	public Category add(Category category) {
		Long id = currentId.incrementAndGet();
		category.setId(id);
		categories.putIfAbsent(id, category);
		return category;
	}

	public List<Category> find() {
		List<Category> allCategories = new ArrayList<>(categories.values());
		return Collections.unmodifiableList(allCategories);
	}

	public Category find(Long id) {
		return categories.get(id);
	}

	public List<Category> find(Category categoryFilter) {
		// just the values
		List<Category> allCategories = new ArrayList<>(categories.values());

		// TODO: change back again to ENUM Category.State.ACTIVE
		List<Category> matchedCategories = filterCategories(
				allCategories,
				nameMatch(categoryFilter.getName()).or(
						stateMatch(categoryFilter.getState())));

		return Collections.unmodifiableList(matchedCategories);
	}

	public Category update(Category category) {
		return categories.replace(category.getId(), category);
	}

	public void delete(Long id) {
		categories.remove(id);
	}
}