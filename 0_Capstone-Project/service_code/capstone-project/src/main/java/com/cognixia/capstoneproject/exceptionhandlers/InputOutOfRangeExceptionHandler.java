package com.cognixia.capstoneproject.exceptionhandlers;


import com.cognixia.capstoneproject.exceptions.InputOutOfRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Defines a Controller Advice for handling any exceptions thrown by the API.
 */
@ControllerAdvice
public class InputOutOfRangeExceptionHandler extends
        ResponseEntityExceptionHandler {

    /**
     * Defines exception handler for the {@link IndexOutOfBoundsException}
     * exception.
     *
     * @param ex - An instance of the InputOutOfRangeException class that is
     * thrown by the API.
     * @return - returns a user readable and HTTP compliant result object.
     */
    @ExceptionHandler(InputOutOfRangeException.class)
    @SuppressWarnings("checkstyle:LineLength")
    public final ResponseEntity<Object> handleInvalidInput(final InputOutOfRangeException ex) {
        return new ResponseEntity<>("Valid input should be between 1 and 3999 for "
                + "conversion.",
                HttpStatus.BAD_REQUEST);

    }
}
