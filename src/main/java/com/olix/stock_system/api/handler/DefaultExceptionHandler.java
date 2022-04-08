package com.olix.stock_system.api.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.olix.stock_system.api.helper.ResponseHelper;
import com.olix.stock_system.domain.exception.ModelNotFoundException;
import com.olix.stock_system.domain.exception.ProductNameInUseException;
import com.olix.stock_system.domain.exception.UnknowAuthorityException;
import com.olix.stock_system.domain.exception.UsernameInUseException;

@ControllerAdvice
public class DefaultExceptionHandler {
	private ResponseHelper responseHelper;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Map<String, String>> methodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		Map<String, String> responseBody = new HashMap<String, String>();
		for (ObjectError error : exception.getAllErrors()) {
			String fieldName = ((FieldError) error).getField();
			String contentField = error.getDefaultMessage();
			responseBody.put(fieldName, contentField);
		}
		return new ResponseEntity<Map<String, String>>(responseBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ModelNotFoundException.class)
	protected ResponseEntity<ResponseHelper> modelNotFoundException(ModelNotFoundException modelNotFoundException) {
		this.responseHelper = new ResponseHelper(modelNotFoundException.getMessage());
		return new ResponseEntity<ResponseHelper>(this.responseHelper, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnknowAuthorityException.class)
	protected ResponseEntity<ResponseHelper> unknowAuthorityException(UnknowAuthorityException exception) {
		this.responseHelper = new ResponseHelper(exception.getMessage());
		return new ResponseEntity<ResponseHelper>(this.responseHelper, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsernameInUseException.class)
	protected ResponseEntity<ResponseHelper> usernameInUseException(UsernameInUseException exception) {
		this.responseHelper = new ResponseHelper(exception.getMessage());
		return new ResponseEntity<ResponseHelper>(this.responseHelper, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<ResponseHelper> httpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		this.responseHelper = new ResponseHelper(
				"An important param has been missing, please check your request body or the path variables");
		return new ResponseEntity<ResponseHelper>(this.responseHelper, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNameInUseException.class)
	protected ResponseEntity<ResponseHelper> productNameInUseException(ProductNameInUseException exception) {
		this.responseHelper = new ResponseHelper(exception.getMessage());
		return new ResponseEntity<ResponseHelper>(this.responseHelper, HttpStatus.BAD_REQUEST);
	}

}
