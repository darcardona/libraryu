package com.darcardona.libraryu.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.darcardona.libraryu.domain.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
	Category findByName(String name);

	List<Category> findByLocation(String location);
}