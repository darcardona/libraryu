package com.darcardona.libraryu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcardona.libraryu.domain.Book;
import com.darcardona.libraryu.repository.BookRepository;
import com.darcardona.libraryu.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepository repository;

  @Override
  public Book save(Book book) {
    return repository.save(book);
  }

  @Override
  public Book get(String isbn) {
    return repository.findByIsbn(isbn);
  }

  @Override
  public List<Book> list() {
    return repository.findAll();
  }

  @Override
  public Boolean delete(String isbn) {
    Book existing = get(isbn);
    if (existing == null)
      return false;
    repository.delete(existing.getId());
    return true;
  }
}
