package com.websystique.springmvc.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class OyoServiceException extends Exception {

	HttpStatus status;
	Exception ex;
	String errorMessage;

	public OyoServiceException() {
		super();
	}

	public OyoServiceException(HttpStatus status, String errorMessage, Exception ex) {
		super(errorMessage, ex);
		ex.printStackTrace();
		this.status = status;
		this.ex = ex;
		this.errorMessage = errorMessage;
	}

	public OyoServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public OyoServiceException(HttpStatus status, Exception ex) {
		super(ex);
		ex.printStackTrace();
		this.status = status;
		this.ex = ex;
	}

	public OyoServiceException(String msg) {
		super(msg);
	}

	public OyoServiceException(Throwable th) {
		super(th);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Exception getEx() {
		return ex;
	}

	public String errorMessage() {
		return errorMessage;
	}

}
