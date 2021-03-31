package com.cg.drycleaning.validators;

import org.springframework.stereotype.Component;

@Component
public class InputValidatorImpl implements InputValidator {
	
	@Override
	public boolean nameValidator(String name) {
		
		return name.matches( "[A-Z][a-z]{3,}" );
	}

	@Override
	public boolean contactValidator(String contact) {
		return contact.matches("[0-9]{10}");
	}

	@Override
	public boolean emailValidator(String email) {
		return email.matches("^(.+)@(.+)$");
	}

	@Override
	public boolean passwordValidator(String password) {
		return password.length()>=3;
	}

	public boolean userIdValidator(String userId) {
		return userId.length()>=3;
	}

}
