package com.darcardona.libraryu.model.dao.account;

/**
 * Created by dar on 11/22/14.
 */
public class User {

	private Long id;

	private String names;

	public User() {
	}

	public User(Long id, String names) {
		this.id = id;
		this.names = names;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}