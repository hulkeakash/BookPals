package com.bookpals.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpals.entity.Book;
import com.bookpals.repository.BookRepository;

@Service
public class BookServiceImpl {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findUsersByBookName(String bookName){
		return bookRepository.findByBookName(bookName);
	}
}
