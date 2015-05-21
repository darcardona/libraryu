package com.darcardona.libraryu.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darcardona.libraryu.domain.Book;
import com.darcardona.libraryu.domain.Category;
import com.darcardona.libraryu.service.BookService;
import com.darcardona.libraryu.service.CategoryService;

@Controller
@RequestMapping("/books")
public class BookController {

  private Logger logger = Logger.getLogger(BookController.class);

  @Autowired
  BookService bookService;

  @Autowired
  CategoryService categoryService;

  @ModelAttribute("categories")
  public List<Category> loadCategories() {
    return categoryService.list();
  }

  @RequestMapping
  public String getStartPage(Model model) {
    List<Book> books = bookService.list();
    model.addAttribute("books", books);

    logger.debug(" getStartPage books:" + books);

    return "books/list";
  }

  @RequestMapping(value = "/delete/{isbn}")
  public String delete(@PathVariable("isbn") String isbn, SessionStatus sessionStatus,
      RedirectAttributes redirectAttrs) {
    logger.debug("/delete/{isbn}:" + isbn);

    boolean deleted = bookService.delete(isbn);

    if (deleted) {
      sessionStatus.setComplete();
      redirectAttrs.addFlashAttribute("successMessage", "deleted " + isbn);
    } else {
      redirectAttrs.addFlashAttribute("errorMessage", "deleted " + isbn);
    }

    return "redirect:../";
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String create(Model model) throws Exception {
    logger.debug("/add GET create");

    model.addAttribute("book", new Book());

    return "books/add";
  }

  @RequestMapping(value = "/edit/{isbn}", method = RequestMethod.GET)
  public String edit(@PathVariable("isbn") String isbn, Model model) throws Exception {
    logger.debug("/edit/{isbn} GET edit");

    Book book = bookService.get(isbn);
    model.addAttribute("book", book);

    return "books/add";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String save(@Valid Book book, BindingResult result, SessionStatus sessionStatus,
      RedirectAttributes redirectAttrs) {
    logger.debug("/add POST save");

    if (result.hasErrors()) {
      return "books/add";
    }

    bookService.save(book);
    sessionStatus.setComplete();
    redirectAttrs.addFlashAttribute("successMessage", book.getIsbn());

    return "redirect:/books";
  }
}
