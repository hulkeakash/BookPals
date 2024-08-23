package com.bookpals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpals.entity.Book;
import com.bookpals.entity.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByBookName(String bookName);
}
