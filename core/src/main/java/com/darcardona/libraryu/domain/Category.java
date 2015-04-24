package com.darcardona.libraryu.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Category {

	@Id
	private String id;

	private String name;

	private String location;

	public Category(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getPersonId() {
		return id;
	}

	public void setPersonId(final String personId) {
		this.id = personId;
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