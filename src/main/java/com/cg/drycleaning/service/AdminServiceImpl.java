package com.cg.drycleaning.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.User;
import com.cg.drycleaning.dao.IAdminRepository;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.validators.InputValidator;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;

	@Autowired
	InputValidator validate;

	@Override
	public void registerAdmin(String userId, String password) throws Exception {
		if (!validate.userIdValidator(userId))
			throw new EntityCreationException("Check Username !!!!");
		if (!validate.passwordValidator(password))
			throw new EntityCreationException("Cannot register this admin with this password");
		User u = new User(userId, password, "ADMIN");
		adminRepository.saveAndFlush(u);
	}

}
