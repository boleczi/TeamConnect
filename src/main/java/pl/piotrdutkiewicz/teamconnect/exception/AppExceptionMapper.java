package pl.piotrdutkiewicz.teamconnect.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AppExceptionMapper implements ExceptionMapper<Exception> {



	
	public Response toResponse(Exception e) {
		
		ResourceError resourceError = new ResourceError();
		
		return null;
	}
	
	
	
	
	 
}
