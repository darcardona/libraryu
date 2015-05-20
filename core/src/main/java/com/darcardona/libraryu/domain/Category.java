package com.darcardona.libraryu.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Category {

	@Id
	private String id;

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@Size(min = 2, max = 30)
	private String location;

	public Category() {

	}

	public Category(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=").append(id).append(", name=")
				.append(name).append(", location=").append(location)
				.append("]");
		return builder.toString();
	}

}