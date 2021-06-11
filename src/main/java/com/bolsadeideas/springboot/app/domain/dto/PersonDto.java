package com.bolsadeideas.springboot.app.domain.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends BaseEntityDto implements Serializable {

    private static final long serialVersionUID = 7104474133411339809L;

    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private String address;

    @NonNull
    private String cellphone;

    @NonNull
    private String cityName;

}
