package com.bookpals.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpals.dto.UserDto;
import com.bookpals.entity.User;
import com.bookpals.mapper.UserMapper;
import com.bookpals.repository.UserRepository;
import com.bookpals.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String addNewUser(UserDto userDto) {
		userRepository.save(UserMapper.INSTANCE.toEntity(userDto));	
		return "Registered Successfully";
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtoList = new ArrayList<>();
		for(User user: userRepository.findAll()) {
			userDtoList.add(UserMapper.INSTANCE.toDto(user));
		}
		return userDtoList;
	}

	@Override
	public UserDto getUserById(Long id) {
		return UserMapper.INSTANCE.toDto(userRepository.findById(id).get());
	}

	@Override
	public String deleteUserById(Long id) {
		userRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public List<UserDto> getUsersReadingSameBook(String bookName) {
		List<UserDto> userDtoList = new ArrayList<>();
		for(User user: userRepository.findUsersByBookName(bookName)) {
			userDtoList.add(UserMapper.INSTANCE.toDto(user));
		}
		return userDtoList;
	}

}
