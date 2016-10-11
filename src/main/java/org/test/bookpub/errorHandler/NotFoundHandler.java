package org.test.bookpub.errorHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangxingxing on 16/9/13.
 */
@ControllerAdvice(basePackages = "org.test")
public class NotFoundHandler{

    private Logger logger = LoggerFactory.getLogger(NotFoundHandler.class);

    public NotFoundHandler() {
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        System.err.println(ex.getMessage());
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

}
