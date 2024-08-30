package com.bookpals.service;

import java.util.List;

import com.bookpals.dto.UserDto;

public interface UserService {
	public String addNewUser(UserDto userDto);
	public List<UserDto> getAllUsers();
	public UserDto getUserById(Long id);
	public String getUserByEmailId(UserDto userDto);
	public String deleteUserById(Long id);
	public List<UserDto> getUsersReadingSameBook(String bookName);
}
