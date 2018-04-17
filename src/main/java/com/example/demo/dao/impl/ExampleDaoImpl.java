package com.example.demo.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import com.example.demo.model.User;
import com.example.demo.config.ExampleCassandraConfig;
import com.example.demo.config.CassandraConfig;
import com.example.demo.dao.base.ExampleDao;

@Repository
public class ExampleDaoImpl implements ExampleDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ExampleCassandraConfig exampleCassandraConfig;
    
    @Autowired
    private CassandraOperations cassandraTemplate;
    
    public List<User>getAllUsers() {
    	User user = new User();
    	user.setUserAge(23);
    	user.setUserId(34);
    	user.setUserName("Dynamic");
    	List<User> userList = new ArrayList<User>();
    	userList.add(user);
    	Statement insert = QueryBuilder.insertInto("user").value("user_id",user.getUserId())
    			.value("user_name",user.getUserName()).value("user_age",user.getUserAge());
    	cassandraTemplate.insert(insert);
    	exampleCassandraConfig.createList(userList);
    	Select select = QueryBuilder.select().all().from("user");
    	List<User> usersList = cassandraTemplate.select(select, User.class);
    	return usersList;
    }
}
