package com.training.libraryu.model.catalog;

import org.junit.Test;

import com.dar.training.libraryu.model.catalog.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by dar on 11/24/14.
 */
public class CollectionTest {

    @Test
    public void negativeValueOnTimeNotAllowed() {
        Collection newCollection = createCollection(1L);
        assertTrue("lending limit >= 0", newCollection.getLendingLimit().intValue() >= 0);
        assertTrue("lending period >= 0", newCollection.getLendingTime().intValue() >= 0);
    }

    private Collection createCollection(Long id) {

        Collection newCollection = new Collection();
        newCollection.setId(id);
        newCollection.setName("General" + id);
        newCollection.setLendingLimit(-2L);
        newCollection.setLendingTime(-3L);

        return newCollection;
    }
}
