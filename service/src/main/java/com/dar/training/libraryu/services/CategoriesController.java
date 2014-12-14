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

import com.dar.training.libraryu.model.catalog.Category;
import com.dar.training.libraryu.repository.CategoryRepository;

@RestController
@RequestMapping("/catalog/categories")
public class CategoriesController {

	Logger logger = LoggerFactory.getLogger(CategoriesController.class);

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
		logger.info("POST< " + category.toString());
		categoryRepository.add(category);
		logger.info("POST> " + category.toString());
		return category;
	}

	/**
	 * add category by @PathVariable name and state
	 * 
	 * @param name
	 * @param state
	 * @return created category
	 */
	@RequestMapping(value = "/{name}/{state}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCategoryByPathVariable(@PathVariable String name,
			@PathVariable String state) {
		logger.info("POST< " + name + "/" + state);
		Category category = categoryRepository.add(new Category(name, state));
		logger.info("POST> " + category.toString());
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
			@RequestParam String state) {
		logger.info("POST< " + name + "/" + state);
		Category category = categoryRepository.add(new Category(name, state));
		logger.info("POST> " + category.toString());
		return category;
	}

	/**
	 * find category by id
	 * 
	 * @param id
	 * @return category found
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Category findCategoryById(@PathVariable Long id) {
		logger.info("GET< " + id);
		Category category = categoryRepository.find(id);
		logger.info("GET> " + category.toString());
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
		logger.info("GET<");
		List<Category> categories = categoryRepository.find();
		logger.info("GET> size " + categories.size());
		return categories;
	}

	/**
	 * find category by example
	 * 
	 * @param category
	 *            working as filter
	 * @return categories found
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Category> findCategory(@RequestBody Category category) {
		logger.info("GET<" + category.toString());
		List<Category> categories = categoryRepository.find(category);
		logger.info("GET> size " + categories.toString());
		return categories;
	}

	/**
	 * delete category by id
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(Long id) {
		logger.info("DELETE<" + id);
		categoryRepository.delete(id);
		logger.info("DELETE> ok");
	}

	/**
	 * updates category
	 * 
	 * @param category
	 *            with updated info
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCategory(@RequestBody Category category) {
		logger.info("PUT< " + category.toString());
		Category previous = categoryRepository.update(category);
		logger.info("PUT> previous " + previous.toString());
	}

}