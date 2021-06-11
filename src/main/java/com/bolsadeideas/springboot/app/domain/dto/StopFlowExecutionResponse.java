package com.bolsadeideas.springboot.app.domain.dto;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StopFlowExecutionResponse implements Serializable {

    private static final long serialVersionUID = 8804498605112379792L;
    protected String error;
    protected Integer status;
    protected String path;
    private String message;

}
