package com.swengin.stardust.cafe;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class StardustCafeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StardustCafeException.class)
    protected ResponseEntity<Object> handleStardustCafeException(StardustCafeException ex) {
        StardustCafeError stardustCafeError = new StardustCafeError(HttpStatus.NOT_ACCEPTABLE.value());
        stardustCafeError.setMessage(ex.getMessage());
        return new ResponseEntity<>(stardustCafeError, HttpStatus.NOT_ACCEPTABLE);
    }
}
