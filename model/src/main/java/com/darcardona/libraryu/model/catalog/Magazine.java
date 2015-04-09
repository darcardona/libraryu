package com.darcardona.libraryu.model.catalog;

import java.util.Date;

/**
 * Created by dar on 11/23/14.
 */
public class Magazine extends Item {

	private Date publicationDate;
	
	public Magazine() {
	}

	public Magazine(Long id, String author, String title, String review,
			Category category, Date publicationDate) {
		super(id, author, title, review, category);
		this.publicationDate = publicationDate;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
}