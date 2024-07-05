package br.com.matheuscsant.estudando_spring.services.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataBaseException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public DataBaseException(String message) {
		super(message);
	}

}
