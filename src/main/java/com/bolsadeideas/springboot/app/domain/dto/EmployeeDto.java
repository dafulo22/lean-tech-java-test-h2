package com.bolsadeideas.springboot.app.domain.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto extends BaseEntityDto implements Serializable {

    private static final long serialVersionUID = -4520116626029002708L;

    private Integer salary;

    private PersonDto person;

    private PositionDto position;

}
