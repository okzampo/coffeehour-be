package com.okzampo.coffehour.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
   private String id;
   private String className;
   private String message; 
}
