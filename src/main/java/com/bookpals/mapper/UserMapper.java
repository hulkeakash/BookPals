package com.bookpals.mapper;

import com.bookpals.dto.UserDto;
import com.bookpals.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "booksRead", target = "booksRead")
    UserDto toDto(User user);

    @Mapping(source = "booksRead", target = "booksRead")
    User toEntity(UserDto userDto);
}

/*
 * Setting componentModel to "spring" allows you to inject the mapper directly
 * into Spring services.
 */

