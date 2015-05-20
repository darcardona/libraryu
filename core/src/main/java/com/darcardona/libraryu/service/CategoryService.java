package com.darcardona.libraryu.service;

import java.util.List;

import com.darcardona.libraryu.domain.Category;

public interface CategoryService {

	Category save(Category category);

	Category getByName(String name);

	Category get(String id);

	List<Category> list();

	Boolean delete(String id);

}