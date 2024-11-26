package com.onebank.taskmaster.controlplane.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends AppRuntimeException {
    public InternalServerException(String errorCode, String message) {
        super(errorCode, message);
    }

    public InternalServerException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

}
