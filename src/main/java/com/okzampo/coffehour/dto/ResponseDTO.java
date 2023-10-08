package com.okzampo.coffehour.dto;

import lombok.Data;

@Data
public class ResponseDTO {
   private String id;
   private String className;
   private Exception exception;
   private String message; 
}
