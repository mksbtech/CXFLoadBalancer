package com.milan.cxf.jaxrs.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class ApplicationExceptionMapper implements ExceptionMapper<AppException>{

	public Response toResponse(AppException ex) {
		return Response.status(ex.getStatus())
				.entity(new ErrorMessage(ex))
				.type(MediaType.APPLICATION_JSON).
				build();
	}
}
