package org.codejudge.sb.controller;

import org.codejudge.sb.exception.BadRequestException;
import org.codejudge.sb.exception.QuestionException;
import org.codejudge.sb.payload.CustomizedExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    static int count = 0;

    @ExceptionHandler({BadRequestException.class})
    public final ResponseEntity<CustomizedExceptionResponse> handleNotFoundException(BadRequestException ex, WebRequest request) {
        System.out.println("asd"+count++);
        CustomizedExceptionResponse customizedExceptionResponse = new CustomizedExceptionResponse("failure","Reason yet to be ascertained");
        return new ResponseEntity<CustomizedExceptionResponse>(customizedExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
