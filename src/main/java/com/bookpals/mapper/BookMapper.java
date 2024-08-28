package com.bookpals.mapper;

import com.bookpals.dto.BookDto;
import com.bookpals.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "user.id", target = "userId")
    BookDto toDto(Book book);

    @Mapping(source = "userId", target = "user.id")
    Book toEntity(BookDto bookDto);
}
