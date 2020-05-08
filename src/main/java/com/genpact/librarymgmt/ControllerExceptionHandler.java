package com.genpact.librarymgmt;

import com.genpact.librarymgmt.exceptions.BookNotException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleError(Exception e) {
        return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BookNotException.class)
    public ResponseEntity handleError(BookNotException e) {
        return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
}
