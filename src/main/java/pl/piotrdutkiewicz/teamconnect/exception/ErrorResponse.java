package pl.piotrdutkiewicz.teamconnect.exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;
    private String error_code;
    private String message;
    private String detail;
    
    
    public static final class ApiErrorResponseBuilder {
        private HttpStatus status;
        private String error_code;
        private String message;
        private String detail;

         ApiErrorResponseBuilder() {
        }

        public static ApiErrorResponseBuilder anApiErrorResponse() {
            return new ApiErrorResponseBuilder();
        }

        public ApiErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder withError_code(String error_code) {
            this.error_code = error_code;
            return this;
        }

        public ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponseBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.status = this.status;
            errorResponse.error_code = this.error_code;
            errorResponse.detail = this.detail;
            errorResponse.message = this.message;
            return errorResponse;
        }
    }


	public HttpStatus getStatus() {
		
		return this.status;
	}
}