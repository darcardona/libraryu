package com.dar.training.libraryu.model.catalog;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dar on 11/22/14.
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	// public enum State {
	// ACTIVE, INACTIVE
	// }

	private Long id;

	@NotNull
	@Size(min = 2, max = 60)
	private String name;

	@NotNull
	@Size(min = 2, max = 10)
	private String state;

	public Category() {

	}

	public Category(String name, String state) {
		this.name = name;
		this.state = state;
	}

	public Category(String state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", state=" + state
				+ "]";
	}
}
