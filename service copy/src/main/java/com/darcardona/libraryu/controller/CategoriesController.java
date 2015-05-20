package com.darcardona.libraryu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.darcardona.libraryu.domain.Category;
import com.darcardona.libraryu.repository.CategoryRepository;

@RestController
@RequestMapping("/catalog/categories")
public class CategoriesController {

	final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * add category by json object
	 *
	 * @param category
	 * @return created category
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCategory(@RequestBody Category category) {
		categoryRepository.save(category);
		return category;
	}

	/**
	 * add category by @PathVariable name and state
	 * 
	 * @param name
	 * @param state
	 * @return created category
	 */
	@RequestMapping(value = "/{name}/{location}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCategoryByPathVariable(@PathVariable String name,
			@PathVariable String location) {
		Category category = new Category(name, location);
		categoryRepository.save(category);
		return category;
	}

	/**
	 * add category by @RequestParam name and state
	 *
	 * @param name
	 * @param state
	 * @return created category
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCategoryByRequestParam(@RequestParam String name,
			@RequestParam String location) {
		Category category = new Category(name, location);
		categoryRepository.save(category);
		return category;
	}

	/**
	 * find category by id
	 * 
	 * @param id
	 * @return category found
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Category findCategoryById(@PathVariable String id) {
		Category category = categoryRepository.findOne(id);
		return category;
	}

	/**
	 * find all categories in the repo
	 * 
	 * @return all categories
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Category> findAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	/**
	 * find category by example
	 * 
	 * @param category working as filter
	 * @return categories found
	 */
	// @RequestMapping(value = "/lookup", method = RequestMethod.GET)
	// @ResponseStatus(HttpStatus.OK)
	// public List<Category> findCategory(@RequestBody Category category) {
	// List<Category> categories = categoryRepository.find(category);
	// return categories;
	// }

	/**
	 * updates category
	 * 
	 * @param category with updated info
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCategory(@PathVariable String id,
			@RequestBody Category category) {
		category.setId(id);
		categoryRepository.save(category);
	}

	/**
	 * delete category by id
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(@PathVariable String id) {
		categoryRepository.delete(id);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handleBadRequests(Exception e) {
		return e.getMessage();
	}
}