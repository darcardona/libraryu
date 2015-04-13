package com.darcardona.libraryu.model.dao.catalog;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by dar on 11/22/14.
 */
@Document(collection = "categories")
public class Category {

	@Id
	private String id;

	@NotNull
	@Size(min = 2, max = 60)
	private String name;

	// @DateTimeFormat(iso = ISO.DATE_TIME)
	// private Date creationDate;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public Date getCreationDate() {
	// return creationDate;
	// }
	//
	// public void setCreationDate(Date creationDate) {
	// this.creationDate = creationDate;
	// }

	@Override
	public String toString() {
		return "CategoryDO [id=" + id + ", name=" + name + "]";
		// return "CategoryDO [id=" + id + ", name=" + name + ", creationDate="
		// + creationDate + "]";
	}
}