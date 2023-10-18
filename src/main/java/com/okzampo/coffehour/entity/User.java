package com.okzampo.coffehour.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}
