package com.bolsadeideas.springboot.app.application.commons.exception;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.domain.dto.StopFlowExecutionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class LeanTechExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StopFlowExecutionException.class)
    public ResponseEntity<StopFlowExecutionResponse> handleAllExceptions(
        StopFlowExecutionException e, WebRequest request) {

        StopFlowExecutionResponse response = StopFlowExecutionResponse.builder()
            .message(e.getMessage())
            .error(HttpStatus.BAD_REQUEST.name())
            .status(HttpStatus.BAD_REQUEST.value())
            .path(request.getContextPath()).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
