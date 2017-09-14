package com.kelikkai.user.repository;

import com.kelikkai.user.domain.User;

public interface UserRepository
{
	public void registerUser(User user);
	
	public void updateUser(User updateUser);
	
	public User getUser(String userId);
}
