package com.dar.training.libraryu.model.catalog.item;

import org.junit.Test;

import com.dar.training.libraryu.model.catalog.item.Book;
import com.dar.training.libraryu.model.catalog.item.Item;

import static org.junit.Assert.assertNotNull;

/**
 * Created by dar on 11/23/14.
 */
public class ItemTest {

    @Test
    public void createBookItem() {
        Item item = new Book();
        assertNotNull(item);
    }


}
