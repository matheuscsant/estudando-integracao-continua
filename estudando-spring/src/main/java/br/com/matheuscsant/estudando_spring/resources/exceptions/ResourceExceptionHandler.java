package br.com.matheuscsant.estudando_spring.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.matheuscsant.estudando_spring.services.exceptions.DataBaseException;
import br.com.matheuscsant.estudando_spring.services.exceptions.ResourceAlreadyExistsException;
import br.com.matheuscsant.estudando_spring.services.exceptions.ResourceNotFoundException;
import br.com.matheuscsant.estudando_spring.utils.DateTimeUtils;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardError> numberFormatException(NumberFormatException e, HttpServletRequest request) {
		String error = "Use um valor númerico";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now()),
				status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<StandardError> divisionByZero(ArithmeticException e, HttpServletRequest request) {
		String error = "Operação não suportada";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now()),
				status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now()),
				status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
		String error = "Erro no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now()),
				status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {
		String error = "Erro de integridade no banco de dados";
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now()),
				status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<StandardError> resourceAlreadyExistsException(ResourceAlreadyExistsException e,
			HttpServletRequest request) {
		String error = "Recurso já existente";
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now()),
				status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

}
