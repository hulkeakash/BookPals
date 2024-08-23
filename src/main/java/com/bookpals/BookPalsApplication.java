package com.bookpals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookpals.serviceimpl.BookServiceImpl;

@SpringBootApplication
public class BookPalsApplication implements CommandLineRunner {

	@Autowired
	BookServiceImpl bookServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(BookPalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(bookServiceImpl.findUsersByBookName("Harry Potter"));
	}

}
