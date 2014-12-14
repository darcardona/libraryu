package com.dar.training.libraryu.repository;

import org.junit.Before;
import org.junit.Test;

import com.dar.training.libraryu.model.catalog.Collection;
import com.dar.training.libraryu.repository.CollectionRepository;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by dar on 11/23/14.
 */
public class CollectionRepositoryTest {

    AtomicLong id;
    CollectionRepository collectionHandler;

    @Before
    public void setup() {
        id = new AtomicLong();
        collectionHandler = new CollectionRepository();
    }

    @Test
    public void addCollection() {
        Collection newCollection = createCollection();
        collectionHandler.insert(newCollection);

        Collection collectionFound = collectionHandler.findById(newCollection.getId());
        assertNotNull("collection added not null", collectionFound);
        assertEquals("collection found equals added", newCollection, collectionFound);
    }

    @Test
    public void getAllCollection() {
        int collectionCreated = 10;
        for (int i = 0; i < collectionCreated; i++) {
            collectionHandler.insert(createCollection());
        }

        assertTrue("get all created", 10 == collectionHandler.findAll().size());
    }

    @Test
    public void updateCategory() {
        Collection newCollection = createCollection();
        collectionHandler.insert(newCollection);

        Collection collectionToUpdate = collectionHandler.findById(newCollection.getId());
        collectionToUpdate.setName("new name");
        collectionHandler.update(collectionToUpdate);

        Collection collectionUpdated = collectionHandler.findById(newCollection.getId());

        assertEquals("handlers name updated", "new name", collectionUpdated.getName());
    }

    @Test
    public void removeCategory() {
        Collection newCollection = createCollection();
        collectionHandler.insert(newCollection);

        collectionHandler.delete(newCollection);

        Collection collectionFound = collectionHandler.findById(newCollection.getId());
        assertNull("handlers deleted", collectionFound);
    }

    private Collection createCollection() {
        Long currentId = id.incrementAndGet();

        Collection newCollection = new Collection();
        newCollection.setId(currentId);
        newCollection.setName("General" + currentId);
        newCollection.setLendingLimit(-2L);
        newCollection.setLendingTime(-3L);

        return newCollection;
    }
}
