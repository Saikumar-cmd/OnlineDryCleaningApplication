package com.cg.drycleaning.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.User;
import com.cg.drycleaning.dao.IUserRepository;
import com.cg.drycleaning.dao.QueryClassPersisitContext;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityNotFoundException;
import com.cg.drycleaning.validators.InputValidator;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;
	InputValidator validate;
	@Autowired
	QueryClassPersisitContext qcp;

	@Override
	public HttpStatus validateUser(String userId, String password) throws EntityNotFoundException {
		User pUser = qcp.findByUserName(userId);
		if (pUser.getPassword().equals(password))
			return HttpStatus.ACCEPTED;
		else {
			throw new EntityNotFoundException("Invalid Password");
		}
	}

	@Override
	public User addUser(User user) throws EntityCreationException {
		if (!validate.userIdValidator(user.getUserId()))
			throw new EntityCreationException("Check Username !!!!");
		if (!validate.passwordValidator(user.getPassword()))
			throw new EntityCreationException("Cannot register this User with this password");
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User removeUser(User user) {
		try {
			User user2 = qcp.findByUserName(user.getUserId());
			userRepository.deleteById(user2.getid());
			return user2;
		} catch (Exception e) {
			throw new EntityDeletionException("Failed to Delete User");
		}
	}

}
