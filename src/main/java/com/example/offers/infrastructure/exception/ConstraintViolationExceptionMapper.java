package com.example.offers.infrastructure.exception;

import com.example.offers.api.dto.ApiErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class ConstraintViolationExceptionMapper
        implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        List<String> details =
                exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
                        .sorted().toList();

        ApiErrorResponse response =
                new ApiErrorResponse("VALIDATION_ERROR", "Request validation failed", details);

        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON)
                .entity(response).build();
    }
}
