package com.cg.drycleaning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
