package com.darcardona.libraryu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.darcardona.libraryu.model.catalog.Category;

/**
 * Created by dar on 11/22/14.
 */
@Component
public class CategoryRepository implements LibraryURepository<Category> {

	Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

	private AtomicLong currentId = new AtomicLong();

	private ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();

	public Category add(Category category) {
		Long id = currentId.incrementAndGet();
		category.setId(id);
		categories.putIfAbsent(id, category);
		return category;
	}

	public Category find(Long id) {
		return categories.get(id);
	}

	public List<Category> find(Category categoryFilter) {
		// TODO: implement
		List<Category> allCategories = new ArrayList<>(categories.values());
		return Collections.unmodifiableList(allCategories);
	}

	public Category update(Category category) {
		return categories.replace(category.getId(), category);
	}

	public void delete(Long id) {
		categories.remove(id);
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