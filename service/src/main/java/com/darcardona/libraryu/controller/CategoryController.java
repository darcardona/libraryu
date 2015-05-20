package com.darcardona.libraryu.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.darcardona.libraryu.domain.Category;

@Controller
public class CategoryController {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	// @Autowired
	// CategoryRepository categoryRepository;

	@RequestMapping(value = "/category/save", method = RequestMethod.GET)
	public String saveCategoryPage(Model model) {
		logger.info("Returning categorySave.jsp page");
		model.addAttribute("category", new Category());
		return "categorySave";
	}

	@RequestMapping(value = "/category/save.do", method = RequestMethod.POST)
	public String saveCustomerAction(@Valid Category category,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning categorySave.jsp page");
			return "categorySave";
		}
		logger.info("Returning categorySaveSuccess.jsp page");
		model.addAttribute("category", category);
		// categoryRepository.save(category);
		return "categorySaveSuccess";
	}

}
