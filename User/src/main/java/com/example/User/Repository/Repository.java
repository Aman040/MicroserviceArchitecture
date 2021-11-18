package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.Entity.User;

public interface Repository extends JpaRepository<User, Long> {
	public User findByUserId(Long userId);
}
