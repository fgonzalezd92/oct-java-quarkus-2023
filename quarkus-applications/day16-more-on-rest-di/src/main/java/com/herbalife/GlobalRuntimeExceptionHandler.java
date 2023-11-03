package com.herbalife;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class GlobalRuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), "HERBALIFE_E12344", LocalDateTime.now().toString());
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorDto)
                .build();

//        String message = "Error: " + exception.getMessage();
//        return Response
//                .status(Response.Status.INTERNAL_SERVER_ERROR)
//                .entity(message)
//                .build();
    }
}
