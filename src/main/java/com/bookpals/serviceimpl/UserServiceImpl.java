package com.bookpals.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpals.dto.UserDto;
import com.bookpals.entity.User;
import com.bookpals.repository.UserRepository;
import com.bookpals.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String addNewUser(UserDto userDto) {
		userRepository.save(modelMapper.map(userDto, User.class));	
		return "Registered Successfully";
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtoList = new ArrayList<>();
		for(User user: userRepository.findAll()) {
			userDtoList.add(modelMapper.map(user, UserDto.class));
		}
		return userDtoList;
	}

	@Override
	public UserDto getUserById(Long id) {
		return modelMapper.map(userRepository.findById(id).get(), UserDto.class);
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
			userDtoList.add(modelMapper.map(user, UserDto.class));
		}
		return userDtoList;
	}

	@Override
	public String getUserByEmailId(UserDto userDto) {
		for(User user: userRepository.findAll()) {
			if(user.getEmail().equals(userDto.getEmail()) && user.getPassword().equals(userDto.getPassword())) {
				return "granted";
			}
		}
		return "denied";
	}

}
