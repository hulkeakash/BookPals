package com.bookpals.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String userName;
	private String password; 
	private String email;
	private List<BookDto> booksRead; 
}
