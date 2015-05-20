package com.darcardona.libraryu.service;

import java.util.List;

import com.darcardona.libraryu.domain.Book;

public interface BookService {

	Book save(Book book);

	Book get(String isbn);

	List<Book> list();

	void delete(String isbn);

}