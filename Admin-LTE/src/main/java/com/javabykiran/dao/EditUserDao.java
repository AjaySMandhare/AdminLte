package com.javabykiran.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.Users;


@Repository
public class EditUserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Users> getData(int id) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("id", id));
		List<Users> list=criteria.list();
		return list;
		
	}
	public boolean updateUser(Users user) {
	    Session session=sessionFactory.openSession();
	   
	    Transaction tr=session.beginTransaction();
	    session.saveOrUpdate(user);
	    tr.commit();
	    return true;
	}

}



