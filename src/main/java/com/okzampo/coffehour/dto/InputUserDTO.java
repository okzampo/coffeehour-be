package com.okzampo.coffehour.dto;

import lombok.Data;

@Data
public class InputUserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
