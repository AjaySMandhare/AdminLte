package com.javabykiran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.Operatorlist;

@Repository
public class OperatorDao {
	
	
	@Autowired
	private SessionFactory sf;
	

	public List<Operatorlist> OperatorsList() {
		Session session = sf.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Operatorlist>list=session.createCriteria(Operatorlist.class).list();
		return list;
	}
}
