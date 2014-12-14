package com.dar.training.libraryu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.dar.training.libraryu.model.catalog.Collection;

/**
 * Created by dar on 11/22/14.
 */
public class CollectionRepository {

	private AtomicLong currentId = new AtomicLong();
	private ConcurrentMap<Long, Collection> collections = new ConcurrentHashMap<>();

	public Collection insert(Collection collection) {
		Long id = currentId.incrementAndGet();
		collection.setId(id);
		collections.putIfAbsent(collection.getId(), collection);
		return collection;
	}

	public Collection findById(Long id) {
		return collections.get(id);
	}

	public List<Collection> findAll() {
		List<Collection> allCollections = new ArrayList<>(collections.values());
		return Collections.unmodifiableList(allCollections);
	}

	public void update(Collection collection) {
		collections.replace(collection.getId(), collection);
	}

	public void delete(Collection collection) {
		collections.remove(collection.getId());
	}
}