package com.dar.training.libraryu.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dar.training.libraryu.model.catalog.Category;

/**
 * Created by dar on 11/22/14.
 */
@Component
public class CategoryHandler {

	private AtomicLong currentId = new AtomicLong();
	private ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();

	public Category insert(Category category) {
		Long id = currentId.incrementAndGet();
		category.setId(id);
		categories.putIfAbsent(id, category);
		return category;
	}

	public Category findById(Long id) {
		return categories.get(id);
	}

	public List<Category> findAll() {
		List<Category> allCategories = new ArrayList<>(categories.values());
		return Collections.unmodifiableList(allCategories);
	}

	public List<Category> findAllActives() {
		// just the values
		List<Category> allCategories = new ArrayList<>(categories.values());

		// java < 8
		// List<Category> allActiveCategories = new ArrayList<Category>();
		// for (Category category : allCategories) {
		// if (category.getState().equals(Category.State.ACTIVE)) {
		// allCategories.add(category);
		// }
		// }

		// filter with stream java 8
		// Category.State.ACTIVE
		List<Category> allActiveCategories = allCategories.parallelStream()
				.filter(category -> category.getState().equals("ACTIVE"))
				.collect(Collectors.toList());
		return Collections.unmodifiableList(allActiveCategories);
	}

	public void update(Category category) {
		categories.replace(category.getId(), category);
	}

	public void delete(Category category) {
		categories.remove(category.getId());
	}
}