package com.example.demo.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user")
public class User {
	@PrimaryKey("user_id")
	private int userId;
	@Column("user_name")
    private String userName;
	@Column("user_age")
    private int userAge;
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserAge() {
        return userAge;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
    
    public void setUserId(int userId) {
    	this.userId = userId;
    }
    public int getUserId() {
    	return userId;
    }
}
