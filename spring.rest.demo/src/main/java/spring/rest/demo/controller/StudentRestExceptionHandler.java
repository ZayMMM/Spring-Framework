package spring.rest.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(StudentNotFoundException exc) {

		StudentErrorResponce error = new StudentErrorResponce();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(Exception exc) {

		StudentErrorResponce error = new StudentErrorResponce();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
