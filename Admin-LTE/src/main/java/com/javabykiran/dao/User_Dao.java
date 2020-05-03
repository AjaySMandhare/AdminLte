package com.javabykiran.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.User;
import com.javabykiran.model.Users;


@Repository
public class User_Dao {

	@Autowired
	private SessionFactory sf;

	public Serializable register(User user) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Serializable id = session.save(user);
		transaction.commit();
		return id;
	}

	public Serializable addUser(Users users) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Serializable id = session.save(users);
		transaction.commit();
		return id;
	}
	
	public List<Users> userList() {
		Session session = sf.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Users>list=session.createCriteria(Users.class).list();
		return list;
	}
	
	public List<Users> loadUser() {
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Users> list = (List<Users>) sf.openSession()
		.createCriteria(Users.class).list();
		return list;
	}

	
	

}
