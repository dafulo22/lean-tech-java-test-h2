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
public class PositionDto extends BaseEntityDto implements Serializable {

    private static final long serialVersionUID = -3454155639422301265L;

    private String name;

}
