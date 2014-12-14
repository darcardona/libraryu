package com.dar.training.libraryu.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dar.training.libraryu.handlers.CategoryHandler;
import com.dar.training.libraryu.model.catalog.Category;

@RestController
@RequestMapping("/catalog/categories")
public class CategoriesController {

	Logger logger = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	CategoryHandler categoryHandler;

	/**
	 * create category by json object
	 *
	 * @param category
	 * @return created category
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category createCategory(@RequestBody Category category) {
		logger.info("POST< " + category.toString());
		categoryHandler.insert(category);
		logger.info("POST> " + category.getId());
		return category;
	}

	/**
	 * create category by @PathVariable
	 * 
	 * @param name
	 * @param state
	 * @return created category
	 */
	@RequestMapping(value = "/{name}/{state}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category createCategoryVariable(@PathVariable String name,
			@PathVariable String state) {
		logger.info("POST< " + name + "/" + state);
		Category category = categoryHandler.insert(new Category(name, state));
		// Category category = new Category(name, state);
		logger.info("POST> " + category.toString());
		return category;
	}

	/**
	 * create category by @RequestParam
	 *
	 * @param name
	 * @param state
	 * @return created category
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category createCategoryParam(@RequestParam String name,
			@RequestParam String state) {
		logger.info("POST< " + name + "/" + state);
		Category category = categoryHandler.insert(new Category(name, state));
		logger.info("POST> " + category.toString());
		return category;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Category getCategory(@PathVariable Long id) {
		logger.info("GET< " + id);
		Category category = categoryHandler.findById(id);
		logger.info("GET> " + category.toString());
		return category;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Category> getAllCategories() {
		logger.info("GET<");
		List<Category> categories = categoryHandler.findAll();
		logger.info("GET> size " + categories.size());
		return categories;
	}

}