package com.dar.training.libraryu.handlers;

import java.util.List;

import com.dar.training.libraryu.model.catalog.item.Item;

/**
 * Created by dar on 11/19/14.
 */
public interface Library {

    List<Item> findAll();

    Item findById(Long id);

    Long insert(Item item);

    void update(Item item);

    void delete(Item item);
}
