package com.darcardona.libraryu.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

  @Id
  private String id;

  @NotNull
  @Size(min = 2, max = 30)
  private String isbn;

  @NotNull
  @Size(min = 2, max = 100)
  private String title;

  @NotNull
  @Size(min = 2, max = 50)
  private String author;

  @NotNull
  @Size(min = 3, max = 200)
  private String review;

  @NotNull
  @Size(min = 2, max = 30)
  private String edition;

  @DBRef
  private Category category;

  public Book() {

  }

  public Book(String id, String isbn, String title, String author, String review, String edition,
      Category category) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.review = review;
    this.edition = edition;
    this.category = category;
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(final String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
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
    builder.append("Book [id=").append(id).append(", isbn=").append(isbn).append(", title=")
        .append(title).append(", author=").append(author).append(", review=").append(review)
        .append(", edition=").append(edition).append(", category=").append(category).append("]");
    return builder.toString();
  }

}
