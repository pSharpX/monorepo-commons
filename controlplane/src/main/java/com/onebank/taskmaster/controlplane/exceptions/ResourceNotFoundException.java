package com.onebank.taskmaster.controlplane.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends AppRuntimeException {
    public ResourceNotFoundException(String errorCode, String message) {
        super(errorCode, message);
    }

    public ResourceNotFoundException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

}
