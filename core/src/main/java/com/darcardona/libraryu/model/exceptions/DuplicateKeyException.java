package com.darcardona.libraryu.model.exceptions;

public class DuplicateKeyException extends Exception {

	private static final long serialVersionUID = 6605940056822215099L;

	public DuplicateKeyException() {
		super();
	}

	public DuplicateKeyException(String message) {
		super(message);
	}

	public DuplicateKeyException(Throwable cause) {
		super(cause);
	}

	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
	}

}