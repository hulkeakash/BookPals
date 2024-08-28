package com.bookpals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookpals.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u JOIN u.booksRead b WHERE b.bookName = :bookName")
	public List<User> findUsersByBookName(String bookName);
}
