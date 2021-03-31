package com.cg.drycleaning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drycleaning.exception.ForBiddenException;
import com.cg.drycleaning.service.IAdminService;

@RestController
public class AdminRest {

	@Autowired
	IAdminService adminService;

	@Autowired
	LoginRest logCon;

	@PostMapping("/registeradmin/{username}/{password}")
	public HttpStatus registerAdmin(@PathVariable String username, @PathVariable String password) throws Exception {
		if (logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) {
			adminService.registerAdmin(username, password);
			return HttpStatus.CREATED;
		} else
			throw new ForBiddenException();
	}

}
