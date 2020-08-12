package edu.miu.aspect.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequisitionNotFoundException.class)
    public ResponseEntity<Object> handleRequisitionNotFoundException(
            RequisitionNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp:", LocalDateTime.now());
        body.put("message:", "Requisition not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(
            EmployeeNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp:-", LocalDateTime.now());
        body.put("message:-", "Employee not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNodataFoundException(
            NoDataFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp:-", LocalDateTime.now());
        body.put("message:-", "No Requisitions found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp:- ", LocalDate.now());
        body.put("status:- ", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors:-", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}

/*
* And a recommended practice

Minimally, you should differentiate exceptions related to business logic (e.g., insufficient balance, email address is not valid) from other exceptions (e.g., server not available, unsupported media type, SQLException).

In our REST API, we have a library for Java clients that parses responses and throws only three different exceptions:

400, 401, 403, 404, 409, 422: throw MyBusinessException, which contains a message that can be shown to the end user. The message comes in the response body (exception handling on the service side), but if not present we have a default message specific to each status code.
405, 412, 415: throw HttpClientErrorException with a message that is specific to each status code.
other 4xx codes: throw HttpClientErrorException with a generic message.
5xx codes: throw HttpServerErrorException with a generic message.
All these exceptions are unchecked.
* */
