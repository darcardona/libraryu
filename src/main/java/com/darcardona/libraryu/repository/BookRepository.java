package com.darcardona.libraryu.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.darcardona.libraryu.domain.Book;
import com.darcardona.libraryu.domain.Category;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

	Book findByIsbn(String isbn);

	List<Book> findByTitle(String title);

	List<Book> findByAutor(String autor);

	List<Book> findByEdition(String edition);

	List<Book> findByCategory(Category category);
}