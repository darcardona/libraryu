package com.darcardona.libraryu.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.darcardona.libraryu.domain.Category;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

public class CategoryRepositoryTest extends AbstractIntegrationTestConfig {

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb(
			"libraryu-test");

	// nosql-unit requirement
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private CategoryRepository repository;

	@Test
	@UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
	@ShouldMatchDataSet(location = "/categories.json")
	public void saveCategory() {
		repository.save(new Category("Art", "South"));
		repository.save(new Category("Science", "North"));
		repository.save(new Category("Religion", "West"));
		repository.save(new Category("Politics", "East"));
		repository.save(new Category("Math", "South"));
	}

	@Test
	public void findCategoryByName() {
		Category categoryNamedArt = repository.findByName("Art");

		assertThat(categoryNamedArt).isNotNull();
		assertThat(categoryNamedArt.getLocation()).isEqualTo("South");
	}

	@Test
	public void findCategoryByLocation() {
		List<Category> categoriesLocatedSouth = repository
				.findByLocation("South");

		assertThat(categoriesLocatedSouth).isNotNull();
		assertThat(categoriesLocatedSouth.size()).isEqualTo(2);
		assertThat(categoriesLocatedSouth.get(0).getName()).isEqualTo("Art");
		assertThat(categoriesLocatedSouth.get(1).getName()).isEqualTo("Math");
	}

	@Test
	@UsingDataSet(locations = { "/categories.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void countCategories() {
		long total = repository.count();

		assertThat(total).isEqualTo(5);
	}

	@Test
	@UsingDataSet(locations = { "/categories.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void deleteCategory() {
		assertThat(repository.count()).isEqualTo(5);

		Category categoryNamedReligion = repository.findByName("Religion");

		// should I test this again?
		assertThat(categoryNamedReligion).isNotNull();

		repository.delete(categoryNamedReligion);

		assertThat(repository.count()).isEqualTo(4);
	}

	@Test
	@UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
	public void repositoryShouldReturnEmptyWhenNoCategories() {
		List<Category> categories = repository.findAll();
		assertThat(categories.size()).isEqualTo(0);
	}

	@Test
	@UsingDataSet(locations = { "/categories.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void updateCategories() {
		Category categoryToUpdate = repository.findByName("Religion");
		String categoryIdBeforeUpdate = categoryToUpdate.getId();
		categoryToUpdate.setName("Music");
		repository.save(categoryToUpdate);

		Category categoryNamedMusic = repository.findByName("Music");

		assertThat(repository.count()).isEqualTo(5);
		assertThat(categoryNamedMusic.getId())
				.isEqualTo(categoryIdBeforeUpdate);
	}
}