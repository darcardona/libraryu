package com.darcardona.libraryu.model.catalog;

/**
 * Created by dar on 11/19/14.
 */
public class Item {

	private Long id;

	private String author;

	private String title;

	private String review;

	private Category category;
	
	public Item() {
	}

	public Item(Long id, String author, String title, String review,
			Category category) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.review = review;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=").append(id).append(", author=")
				.append(author).append(", title=").append(title)
				.append(", review=").append(review).append(", category=")
				.append(category).append("]");
		return builder.toString();
	}
}