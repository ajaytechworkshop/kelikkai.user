package com.kelikkai.user.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kelikkai.user.bean.UserDTO;
import com.kelikkai.user.bean.UserUpdateDTO;
import com.kelikkai.user.domain.User;
import com.kelikkai.user.service.UserService;
import com.kelikkai.user.util.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value=Constants.URL_APPROOT)
public class UserController
{
	private Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="The API registers new user")
	@RequestMapping(value=Constants.URL_REGISTERUSER,method=RequestMethod.POST)
	public void registerUser(@ApiParam("User DTO containing the new user registeration details") @RequestBody  UserDTO user)
	{
		log.info("--> UserController registerUser.."+user);
		
		userService.registerUser(user);
		
		log.info("UserController registerUser -->");
	}
	
	@ApiOperation(value="The API registers new user")
	@RequestMapping(value=Constants.URL_UPDATEUSER,method=RequestMethod.PUT)
	public void updateUser(@ApiParam("User DTO containing the updated user registeration details") @RequestBody  UserUpdateDTO updateUserBean)
	{
		log.info("--> UserController updateUser.."+updateUserBean);
		
		userService.updateUser(updateUserBean);
		
		log.info("UserController updateUser -->");
	}
	
	@ApiOperation(value="The API gets the user details passing the user id")
	@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	public User getUser(@ApiParam("User id whose details needs to be fetched") @PathVariable(value="userId") String userId)
	{
		log.info("--> UserController getUser.."+userId);
		
		User user = userService.getUser(userId);
		
		log.info("UserController getUser -->"+user);
		
		return user;
	}
	
	@ApiOperation(value="The API gets all the users registred in kelikkai")
	@RequestMapping(value=Constants.URL_ALLUSER,method=RequestMethod.GET)
	public List<User> getAllUsers()
	{
		log.info("--> UserController getAllUsers..");
		
		List<User> users = userService.getAllUsers();
		
		log.info("UserController getAllUsers -->"+users);
		
		return users;
	}
}
