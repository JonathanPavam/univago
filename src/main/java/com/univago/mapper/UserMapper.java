package com.univago.mapper;
import com.univago.dto.UserDto;
import com.univago.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto); //recive a dto and return and entity/user
    UserDto toDto(User user); //recive a user/entity and return a dto
}
