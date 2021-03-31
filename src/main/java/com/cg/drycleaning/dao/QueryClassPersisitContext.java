package com.cg.drycleaning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.User;
import com.cg.drycleaning.exception.EntityNotFoundException;

@Repository
public class QueryClassPersisitContext {

	@PersistenceContext
	EntityManager eManager;

	public User findByUserName(String username) throws EntityNotFoundException {
		TypedQuery<User> qry = eManager.createQuery("select u from User u where u.userId like :name", User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if (user.size() == 0)
			throw new EntityNotFoundException("User Not Available !!");
		return user.get(0);
	}

}
