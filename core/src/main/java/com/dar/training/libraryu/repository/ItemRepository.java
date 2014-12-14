package com.dar.training.libraryu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.dar.training.libraryu.model.catalog.item.Item;

/**
 * Created by dar on 11/22/14.
 */
public class ItemRepository {

    private AtomicLong currentId = new AtomicLong();
    private ConcurrentMap<Long, Item> items = new ConcurrentHashMap<>();

    public Item insert(Item item) {
        Long id = currentId.incrementAndGet();
        item.setId(id);
        items.putIfAbsent(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return items.get(id);
    }

    public List<Item> findAll() {
        List<Item> allItems = new ArrayList<>(items.values());
        return Collections.unmodifiableList(allItems);
    }

    public void update(Item collection) {
        items.replace(collection.getId(), collection);
    }

    public void delete(Item collection) {
        items.remove(collection.getId());
    }
}