package com.cg.drycleaning.loginmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.User;
import com.cg.drycleaning.dao.QueryClassPersisitContext;

@Service
public class LoginService {
	@Autowired
	private QueryClassPersisitContext qcp;

	private Login logData = new Login();

	public Login loginWithData(String userId, String password) throws Exception {
		User user = qcp.findByUserName(userId);
		if (!user.getPassword().equals(password))
			throw new Exception("Login Data Invalid");
		logData.setLoginStatus(true);
		logData.setUser(user);
		return logData;
	}

	public Login logoutPresentUser() {
		if (logData.isLoginStatus()) {
			logData.setLoginStatus(false);
		}
		return logData;
	}

	public boolean loginStatus() {
		return logData.isLoginStatus();
	}

	public String getRole() {
		return logData.getRole();
	}

}