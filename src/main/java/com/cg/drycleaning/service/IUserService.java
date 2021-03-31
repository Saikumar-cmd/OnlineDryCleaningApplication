package com.cg.drycleaning.service;

import org.springframework.http.HttpStatus;

import com.cg.drycleaning.beans.User;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;

public interface IUserService {

	HttpStatus validateUser(String username, String password) throws Exception;

	public User addUser(User user) throws EntityCreationException;

	public User removeUser(User user) throws EntityDeletionException;

}
