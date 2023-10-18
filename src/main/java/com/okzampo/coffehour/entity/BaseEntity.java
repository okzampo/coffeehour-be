package com.okzampo.coffehour.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class BaseEntity {
    @Id
    private String id;
}
