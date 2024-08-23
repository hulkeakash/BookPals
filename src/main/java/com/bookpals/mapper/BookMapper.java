package com.bookpals.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bookpals.dto.BookDto;
import com.bookpals.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toBookDto(Book book);

    Book toBook(BookDto bookDto);
}

