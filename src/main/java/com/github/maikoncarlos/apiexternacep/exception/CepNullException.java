package com.github.maikoncarlos.apiexternacep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class CepNullException  extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public CepNullException(String message) {
            super(message);
        }
    }