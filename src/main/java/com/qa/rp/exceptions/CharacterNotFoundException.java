package com.qa.rp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Character not found with that ID")//exception for character not found
public class CharacterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3987704354355977480L;

}
