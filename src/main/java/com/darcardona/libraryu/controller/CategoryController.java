package com.darcardona.libraryu.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darcardona.libraryu.domain.Category;
import com.darcardona.libraryu.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

  private Logger logger = Logger.getLogger(CategoryController.class);

  @Autowired
  CategoryService categoryService;

  @RequestMapping
  public String getStartPage(Model model) {
    List<Category> categories = categoryService.list();
    model.addAttribute("categories", categories);

    logger.debug(" getStartPage categories:" + categories);

    return "categories/list";
  }

  @RequestMapping(value = "/delete/{id}")
  public String deleteCategory(@PathVariable("id") String id, SessionStatus sessionStatus,
      RedirectAttributes redirectAttrs) {
    logger.debug("/delete/{id}:" + id);

    boolean deleted = categoryService.delete(id);

    if (deleted) {
      sessionStatus.setComplete();
      redirectAttrs.addFlashAttribute("successMessage", "deleted " + id);
    } else {
      redirectAttrs.addFlashAttribute("errorMessage", "not deleted " + id);
    }
    return "redirect:../";
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String createCategory(Model model) throws Exception {
    logger.debug("/add GET createCategory");

    model.addAttribute("category", new Category());

    return "categories/add";
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public String editCategory(@PathVariable("id") String id, Model model) throws Exception {
    logger.debug("/edit/{id} GET editCategory");

    Category category = categoryService.get(id);
    model.addAttribute("category", category);

    return "categories/add";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String saveCategory(@Valid Category category, BindingResult result,
      SessionStatus sessionStatus, RedirectAttributes redirectAttrs) {
    logger.debug("/add POST saveCategory");

    if (result.hasErrors()) {
      return "categories/add";
    }

    categoryService.save(category);
    sessionStatus.setComplete();
    redirectAttrs.addFlashAttribute("successMessage", category.getName());

    return "redirect:/categories";
  }
}
