package com.darcardona.libraryu.repository;

import org.junit.Before;
import org.junit.Test;

import com.darcardona.libraryu.model.catalog.Book;
import com.darcardona.libraryu.model.catalog.Category;
import com.darcardona.libraryu.model.catalog.Item;
import com.darcardona.libraryu.model.catalog.Magazine;
import com.darcardona.libraryu.repository.ItemRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by dar on 11/26/14.
 */
public class ItemRepositoryTest {

	AtomicLong id;

	ItemRepository itemHandler;

	@Before
	public void setUp() {
		id = new AtomicLong();
		itemHandler = new ItemRepository();
	}

	@Test
	public void insertBook() {
		Item book = createBook();
		assertNotNull("book created not null", book);
		itemHandler.insert(book);

		Item itemFound = itemHandler.findById(book.getId());
		assertNotNull("book added not null", itemFound);
		assertEquals("book found equals added", book, itemFound);
		assertTrue("book instanceof item", book instanceof Item);
	}

	@Test
	public void insertNBooks() {

		int items = System.getProperty("items") != null ? Integer
				.parseInt(System.getProperty("items")) : 1;
		createAndInsertBooks(items);

		List<Item> toDoItems = itemHandler.findAll();
		assertEquals(items, toDoItems.size());
	}

	private void createAndInsertBooks(int items) {
		for (int i = 1; i <= items; i++) {
			Item book = createBook();
			itemHandler.insert(book);
		}
	}

	public Item createBook() {
		Long currentId = id.incrementAndGet();
		Book book = new Book();
		book.setId(currentId);
		book.setAuthor("author" + currentId);
		book.setTitle("title" + currentId);
		book.setReview("review" + currentId);
		book.setCategory(new Category());
		book.setEdition("edition" + currentId);
		return book;
	}

	public Item createMagazine() {
		Long currentId = id.incrementAndGet();
		Magazine magazine = new Magazine();
		magazine.setId(currentId);
		magazine.setAuthor("author" + currentId);
		magazine.setTitle("title" + currentId);
		magazine.setReview("review" + currentId);
		magazine.setCategory(new Category());
		magazine.setPublicationDate(new Date());
		return magazine;
	}

}
