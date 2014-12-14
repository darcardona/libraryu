package com.dar.training.libraryu.model.catalog;

import org.junit.Ignore;
import org.junit.Test;

import com.dar.training.libraryu.model.catalog.Category;

import static org.junit.Assert.assertNotNull;

/**
 * Created by dar on 11/24/14.
 */
public class CategoryTest {

    @Test @Ignore
    public void stateCannotBeNullWhenCreated() {
        Category category = new Category();
        assertNotNull(category.getState());
    }
}
