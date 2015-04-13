package com.darcardona.libraryu.model.exceptions;

public class BaseDAOException extends Exception {

	private static final long serialVersionUID = -718971523435235478L;

	public BaseDAOException() {
		super();
	}

	public BaseDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseDAOException(String message) {
		super(message);
	}

	public BaseDAOException(Throwable cause) {
		super(cause);
	}
}