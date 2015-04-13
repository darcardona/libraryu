package com.darcardona.libraryu.model.dao;

import com.darcardona.libraryu.model.exceptions.BaseDAOException;
import com.darcardona.libraryu.model.exceptions.DuplicateKeyException;

public interface BaseDAO<T> {

	public T add(T toAdd) throws BaseDAOException, DuplicateKeyException;

	public T find(String id);

	public T find(T toFind);

	public T update(T toUpdate);

	public void delete(String id);

}