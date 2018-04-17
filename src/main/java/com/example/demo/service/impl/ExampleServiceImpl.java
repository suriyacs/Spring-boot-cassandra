package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.base.ExampleService;
import com.example.demo.dao.base.ExampleDao;
import com.example.demo.model.User;

@Service
public class ExampleServiceImpl implements ExampleService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private ExampleDao exampleDao;
	
	User firstUser = new User();
	User secondUser = new User();
	List<User> userList = new ArrayList<User>();
	public List<User> getUserById(int userId) {
		firstUser.setUserId(1);
		firstUser.setUserName("suriya");
		firstUser.setUserAge(23);
		userList.add(firstUser);
		secondUser.setUserId(2);
		secondUser.setUserName("kumar");
		secondUser.setUserAge(23);
		userList.add(secondUser);
		return exampleDao.getAllUsers();
	}
}
