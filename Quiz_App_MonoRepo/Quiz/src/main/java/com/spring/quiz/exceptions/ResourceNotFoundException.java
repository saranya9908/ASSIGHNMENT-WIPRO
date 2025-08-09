package com.spring.quiz.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
