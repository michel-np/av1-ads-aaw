package com.aaw.av1aaw.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = -687991492884005033L;
	
	public NotFoundException(String msg) {
		super(msg);
	}
}
