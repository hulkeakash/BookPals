package com.bookpals.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.bookpals.dto.UserDto;
import com.bookpals.entity.User;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "currentlyReading", target = "currentlyReading")
    @Mapping(source = "alreadyReadBooks", target = "alreadyReadBooks")
    UserDto toUserDto(User user);

    @Mapping(source = "currentlyReading", target = "currentlyReading")
    @Mapping(source = "alreadyReadBooks", target = "alreadyReadBooks")
    User toUser(UserDto userDto);
}

/*
 * Setting componentModel to "spring" allows you to inject the mapper directly
 * into Spring services.
 */

