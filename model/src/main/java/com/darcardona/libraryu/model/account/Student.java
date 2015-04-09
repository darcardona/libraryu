package com.darcardona.libraryu.model.account;

/**
 * Created by dar on 11/23/14.
 */
public class Student extends User {

    private String faculty;

    public Student(Long id, String names, String faculty) {
		super(id, names);
		this.faculty = faculty;
	}

	public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}