package com.okzampo.coffehour.mapper;


import com.okzampo.coffehour.dto.InputUserDTO;
import com.okzampo.coffehour.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InputUserMapper extends BaseMapper<User, InputUserDTO> {
}
