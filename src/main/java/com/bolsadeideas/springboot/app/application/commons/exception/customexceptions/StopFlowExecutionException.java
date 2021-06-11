package com.bolsadeideas.springboot.app.application.commons.exception.customexceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StopFlowExecutionException extends RuntimeException {

    private static final long serialVersionUID = -3605107727888822422L;

    private final String message;
    private String error;
    private Integer status;
    private String path;

    public StopFlowExecutionException(String message) {
        super(message);
        this.message = message;
    }

}
