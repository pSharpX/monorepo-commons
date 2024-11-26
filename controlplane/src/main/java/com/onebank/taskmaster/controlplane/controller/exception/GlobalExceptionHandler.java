package com.onebank.taskmaster.controlplane.controller.exception;

import com.onebank.taskmaster.controlplane.exceptions.BadRequestException;
import com.onebank.taskmaster.controlplane.exceptions.InternalServerException;
import com.onebank.taskmaster.controlplane.exceptions.ResourceNotFoundException;
import com.onebank.taskmaster.controlplane.exceptions.handler.AbstractExceptionHandler;
import com.onebank.taskmaster.controlplane.exceptions.model.GenericErrorResponse;
import com.onebank.taskmaster.controlplane.exceptions.utils.ExceptionConstantsUtils;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Optional;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends AbstractExceptionHandler<GenericErrorResponse> {

    @ExceptionHandler({
            IllegalArgumentException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            ConstraintViolationException.class,
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericErrorResponse handleBadRequestException(Exception ex) {
        log.error("Handle Bad Request Error: {}", ExceptionUtils.getStackTrace(ex));
        return GenericErrorResponse.badRequest(ex.getMessage());
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericErrorResponse handleBadRequestException(HandlerMethodValidationException ex) {
        String errorMessage = ex.getAllValidationResults().stream()
                .flatMap(validationResult -> validationResult.getResolvableErrors().stream())
                .map(messageSourceResolvable -> Optional.ofNullable(messageSourceResolvable.getDefaultMessage()).orElse(ExceptionConstantsUtils.BAD_REQUEST_ERROR_MESSAGE))
                .findFirst().orElse(ExceptionConstantsUtils.BAD_REQUEST_ERROR_MESSAGE);
        return GenericErrorResponse.badRequest(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericErrorResponse handleBadRequestException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> Optional.ofNullable(fieldError.getDefaultMessage())
                        .orElse(ExceptionConstantsUtils.BAD_REQUEST_ERROR_MESSAGE))
                .findFirst().orElse(ex.getMessage());
        return GenericErrorResponse.badRequest(message);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericErrorResponse handleBadRequestException(BadRequestException ex) {
        String errorCode = ex.getErrorCode();
        String message = ex.getMessage();
        log.error("Handle Bad Request Error Code: {}, Message: {}", errorCode, message);
        return GenericErrorResponse.badRequest(errorCode, message);
    }

    @ExceptionHandler({
            InternalServerException.class,
            NullPointerException.class,
            Exception.class,
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GenericErrorResponse handleInternalServerException(Exception ex) {
        log.error("Handle Internal Server Error: {}", ExceptionUtils.getStackTrace(ex));
        GenericErrorResponse errorResponse = GenericErrorResponse.internalServer();
        if (ex instanceof InternalServerException internalServerException) {
            String errorCode = internalServerException.getErrorCode();
            String message = internalServerException.getMessage();
            errorResponse = GenericErrorResponse.build(errorCode, message);
        }
        return errorResponse;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericErrorResponse handleResourceNotFoundException(Exception ex) {
        log.error("Handle Resource Not Found Error: {}", ExceptionUtils.getStackTrace(ex));
        return GenericErrorResponse.notFound(ex.getMessage());
    }

}
