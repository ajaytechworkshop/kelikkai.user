package com.kelikkai.user.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelikkai.user.bean.UserDTO;
import com.kelikkai.user.bean.UserUpdateDTO;
import com.kelikkai.user.domain.User;
import com.kelikkai.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepo;
	
	private Logger log = Logger.getLogger(UserServiceImpl.class);
	
	public void registerUser(UserDTO user)
	{
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		userRepo.registerUser(newUser);
	}

	@Override
	public void updateUser(UserUpdateDTO updateUserDTO)
	{
		User updateUser = new User();
		BeanUtils.copyProperties(updateUserDTO, updateUser);
		userRepo.updateUser(updateUser);
	}

	@Override
	public User getUser(String userId)
	{
		return userRepo.getUser(userId);
	}

	@Override
	public List<User> getAllUsers()
	{
		return userRepo.getAllUsers();
	}
	
	
}
