package com.darcardona.libraryu.model.catalog;

/**
 * Created by dar on 11/23/14.
 */
public class Book extends Item {

	private String edition;

	public Book() {
	}

	public Book(Long id, String author, String title, String review,
			Category category, String edition) {
		super(id, author, title, review, category);
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
}
