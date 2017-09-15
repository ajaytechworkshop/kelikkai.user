package com.kelikkai.user.service;

import java.util.List;

import com.kelikkai.user.bean.UserDTO;
import com.kelikkai.user.bean.UserUpdateDTO;
import com.kelikkai.user.domain.User;

public interface UserService
{
	public void registerUser(UserDTO user);
	
	public void updateUser(UserUpdateDTO updateUserDTO);
	
	public User getUser(String userId);
	
	public List<User> getAllUsers();
}
