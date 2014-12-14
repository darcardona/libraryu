package com.dar.training.libraryu.model.account;

/**
 * Created by dar on 11/23/14.
 */
public class Student extends User {

    private String faculty;

    public Student(Long id, String name, String faculty) {
        super.setId(id);
        super.setName(name);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}