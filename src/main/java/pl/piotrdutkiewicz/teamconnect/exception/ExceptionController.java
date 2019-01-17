package pl.piotrdutkiewicz.teamconnect.exception;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.tools.web.BadHttpRequest;

@RestControllerAdvice
@Component
public class ExceptionController extends ResponseEntityExceptionHandler {

	// @Override
	// protected ResponseEntity<Object>
	// handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	// HttpHeaders headers, HttpStatus status, WebRequest request) {
	// List<String> errors = new ArrayList<String>();
	// for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	// errors.add(error.getField() + ": " + error.getDefaultMessage());
	// }
	// for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	// errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	// }
	//
	// ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,
	// ex.getLocalizedMessage(), errors);
	// System.out.println(" exception handled ");
	// return handleExceptionInternal(ex, apiError, headers,
	// apiError.getStatus(), request);
	// }

	// @Override
	// protected ResponseEntity<Object>
	// handleMissingServletRequestParameter(MissingServletRequestParameterException
	// ex,
	// HttpHeaders headers, HttpStatus status, WebRequest request) {
	// String error = ex.getParameterName() + " parameter is missing";
	//
	// ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,
	// ex.getLocalizedMessage(), error);
	// return new ResponseEntity<Object>(apiError, new HttpHeaders(),
	// apiError.getStatus());
	// }

	@ExceptionHandler({ ConstraintViolationException.class })
	protected ResponseEntity<ApiError> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		System.out.println("-------------------- ConstraintViolationException");
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
					+ violation.getMessage());
		}

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	// @ExceptionHandler({ NoHandlerFoundException.class })
	// protected ResponseEntity<Object>
	// NoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
	// HttpStatus status, WebRequest request){
	// String error = ex.getHeaders() + " Parameter not found ";
	// ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
	// ex.getLocalizedMessage(), error);
	// return new ResponseEntity<Object>(apiError, new HttpHeaders(),
	// apiError.getStatus());
	//
	// }
	// @ResponseStatus(value="HttpStatus.NOT_FOUND",reason"This customer is not
	// found in the system")
	
	
	@ExceptionHandler({ ApiResourceNotFoundException.class })
	protected ResponseEntity<ApiError> handleApiResourceNotFoundException(ApiResourceNotFoundException ex, WebRequest request) {
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex.getDetails());
		return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());

		// return handleExceptionInternal(new Exception(ex), apiError, new
		// HttpHeaders(),ex.getStatus(),
		// request);

	}

	// @Override
	// protected ResponseEntity<Object>
	// handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
	// HttpHeaders headers, HttpStatus status, WebRequest request) {
	// System.out.println("-------------------- ResponseStatusException");
	// String error = "Malformed JSON request ";
	// TeamException response =
	// TeamException.builder().withStatus(status).withMessage(ex.getLocalizedMessage())
	// .withDetail(error + ex.getMessage()).build();
	// return new ResponseEntity<Object>(response, response.getStatus());
	// }

	// protected ResponseEntity<Object> handleConflict(RuntimeException ex,
	// WebRequest request) {
	// String bodyOfResponse = "This should be application specific";
	//
	// return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
	// HttpStatus.CONFLICT, request);
	// }

	// @ExceptionHandler({ Throwable.class })
	// protected ResponseEntity<Object> handleInternalServerException(Throwable
	// throwable, WebRequest request) {
	// return handleExceptionInternal(new Exception(throwable),
	// new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error occured!"),
	// new HttpHeaders(),
	// HttpStatus.INTERNAL_SERVER_ERROR, request);
	//
	// }

}
