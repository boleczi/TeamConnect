package pl.piotrdutkiewicz.teamconnect.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

public class ApiError {

	private final HttpStatus status;
	private final String message;
	private final List<String> errors;
	private final UUID errorID;

	public ApiError(HttpStatus status, String message, List<String> errors) {
		this.status = status;
		this.message = message;
		this.errors = errors;
		this.errorID = UUID.randomUUID();
	}

	public ApiError(HttpStatus status, String message, String error) {
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
		this.errorID = UUID.randomUUID();
	}

	public ApiError(HttpStatus status, String message) {
		this.status = status;
		this.errors = new ArrayList<>();
		this.message = message;
		this.errorID = UUID.randomUUID();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public UUID getErrorID() {
		return errorID;
	}

}
