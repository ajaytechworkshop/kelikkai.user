package com.kelikkai.user.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.kelikkai.user.domain.User;

@Repository
public class UserRepoSitoryImpl implements UserRepository
{
	private Logger log = Logger.getLogger(UserRepoSitoryImpl.class);
	
	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public void registerUser(User user)
	{
		mongoOps.save(user);
	}

	@Override
	public void updateUser(User updateUser)
	{
		mongoOps.save(updateUser);
	}

	@Override
	public User getUser(String userId)
	{
		return mongoOps.findById(userId,User.class);
	}
	
	
}
