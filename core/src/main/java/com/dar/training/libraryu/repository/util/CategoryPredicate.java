package com.dar.training.libraryu.repository.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.dar.training.libraryu.model.catalog.Category;

public class CategoryPredicate {

	// http://howtodoinjava.com/2014/04/04/how-to-use-predicate-in-java-8/

	public static Predicate<Category> isStateActive() {
		return p -> p.getState().equalsIgnoreCase("ACTIVE");
	}

	public static Predicate<Category> nameMatch(String name) {
		return p -> name != null && p.getName() != null
				&& p.getName().equalsIgnoreCase(name);
	}

	public static Predicate<Category> stateMatch(String state) {
		return p -> state != null && p.getState() != null
				&& p.getState().equalsIgnoreCase(state);
	}

	/**
	 * Utility method to make code clean and less repetitive
	 * 
	 * @param categories
	 * @param predicate
	 * @return
	 */
	public static List<Category> filterCategories(List<Category> categories,
			Predicate<Category> predicate) {
		return categories.parallelStream().filter(predicate)
				.collect(Collectors.<Category> toList());
	}
}
