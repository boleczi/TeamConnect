package pl.piotrdutkiewicz.teamconnect.exception;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class ApiResourceNotFoundException extends Exception  {

	
	private String message;
	private String detail;

	private ApiResourceNotFoundException() {
	}

	public static ApiResourceNotFoundExceptionBuilder builder() {
		return new ApiResourceNotFoundExceptionBuilder();
	}

	public static final class ApiResourceNotFoundExceptionBuilder {
		private HttpStatus status;
		private String message;
		private String detail;

		private ApiResourceNotFoundExceptionBuilder() {
		}

		public ApiResourceNotFoundExceptionBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiResourceNotFoundExceptionBuilder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public ApiResourceNotFoundException build() {
			ApiResourceNotFoundException errorResponse = new ApiResourceNotFoundException();
//			if (this.status == null)
//				throw new RuntimeException();
			errorResponse.detail = this.detail;
			errorResponse.message = this.message;
			return errorResponse;
		}
	}


	public String getMessage() {

		return this.message;
	}

	public String getDetails() {

		return this.detail;
	}
}