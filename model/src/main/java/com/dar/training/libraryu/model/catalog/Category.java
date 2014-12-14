package com.dar.training.libraryu.model.catalog;

import java.io.Serializable;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dar on 11/22/14.
 */
// @XmlRootElement(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	// public enum State {
	// ACTIVE, INACTIVE
	// }

	private Long id;
	private String name;
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

	// @XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	// @XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	// @XmlElement
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", state=" + state
				+ "]";
	}
}
