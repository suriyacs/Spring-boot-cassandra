package com.example.demo.dao.base;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface ExampleDao {
	List<User> getAllUsers();
}
