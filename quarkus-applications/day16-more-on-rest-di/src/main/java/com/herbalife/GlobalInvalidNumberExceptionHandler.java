package com.herbalife;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class GlobalInvalidNumberExceptionHandler implements ExceptionMapper<InvalidNumberException> {
    @Override
    public Response toResponse(InvalidNumberException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), "HERBALIFE_E1235", LocalDateTime.now().toString());
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
