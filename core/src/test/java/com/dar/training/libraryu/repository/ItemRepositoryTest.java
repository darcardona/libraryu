package com.dar.training.libraryu.repository;

import org.junit.Before;
import org.junit.Test;

import com.dar.training.libraryu.model.catalog.item.Book;
import com.dar.training.libraryu.model.catalog.item.Item;
import com.dar.training.libraryu.model.catalog.item.Magazine;
import com.dar.training.libraryu.repository.ItemRepository;

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

        int items = System.getProperty("items") != null ? Integer.parseInt(System.getProperty("items")) : 1;
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
        book.setName("name" + currentId);
        book.setAuthor("author" + currentId);
        book.setEdition("edition" + currentId);
        return book;
    }

    public Item createMagazine() {
        Long currentId = id.incrementAndGet();
        Magazine magazine = new Magazine();
        magazine.setId(currentId);
        magazine.setName("name" + currentId);
        magazine.setAuthor("autor" + currentId);
        magazine.setIssue("issue" + currentId);
        return magazine;
    }

}
