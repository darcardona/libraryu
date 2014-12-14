package com.dar.training.libraryu.repository;

import java.util.List;

/**
 * Created by dar on 11/19/14.
 */
public interface LibraryURepository<T> {

	T add(T item);

	T find(Long id);

	List<T> find();

	List<T> find(T item);

	T update(T item);

	void delete(Long id);
}
