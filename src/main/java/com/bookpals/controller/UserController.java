package com.bookpals.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpals.dto.UserDto;
import com.bookpals.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/signup")
	public ResponseEntity<String> addNewUser(@RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.addNewUser(userDto));
	}
	
	@GetMapping("/signin")
	public ResponseEntity<String> getUserByEmail(@RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserByEmailId(userDto));
	}
	
	@GetMapping("/sameBookReader/{bookName}")
	public ResponseEntity<List<UserDto>> getUsersReadingSameBook(@PathVariable String bookName){
		List<UserDto> userDtoList = userServiceImpl.getUsersReadingSameBook(bookName);
		if(userDtoList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(userDtoList));
		}
	}
}
