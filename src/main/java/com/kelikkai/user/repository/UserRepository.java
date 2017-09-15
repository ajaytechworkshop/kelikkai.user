package com.kelikkai.user.repository;

import java.util.List;

import com.kelikkai.user.domain.User;

public interface UserRepository
{
	public void registerUser(User user);
	
	public void updateUser(User updateUser);
	
	public User getUser(String userId);
	
	public List<User> getAllUsers();
}
