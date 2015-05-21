package com.darcardona.libraryu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcardona.libraryu.domain.Category;
import com.darcardona.libraryu.repository.CategoryRepository;
import com.darcardona.libraryu.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository repository;

  @Override
  public Category save(Category category) {
    return repository.save(category);
  }

  @Override
  public Category getByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public Category get(String id) {
    return repository.findOne(id);
  }

  @Override
  public List<Category> list() {
    return repository.findAll();
  }

  @Override
  public Boolean delete(String id) {
    Category existing = get(id);
    if (existing == null)
      return false;
    repository.delete(existing);
    return true;
  }
}
