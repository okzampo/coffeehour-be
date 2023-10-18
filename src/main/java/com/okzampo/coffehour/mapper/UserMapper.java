package com.okzampo.coffehour.mapper;

import com.okzampo.coffehour.dto.UserDTO;
import com.okzampo.coffehour.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper extends BaseMapper<User, UserDTO> {
}
