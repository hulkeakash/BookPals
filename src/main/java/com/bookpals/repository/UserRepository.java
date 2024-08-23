package com.bookpals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpals.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
