package com.javabykiran.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.Users;


@Repository
public class DeleteUserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Users deleteUser(int id) {
		
		System.out.println("i am in DeleteUserDao");
		Session session=sessionFactory.openSession();
		 Users user=session.load(Users.class, id);
		 String isDefault=user.getIsdefault();
				if(isDefault.equals("No"))
				 session.delete(user);
		Transaction tt= session.beginTransaction();
		tt.commit();
		System.out.println("record deleted");
		return user;
		
	}
	
	public boolean deleteMultiUser(int[] id) {
		System.out.println("i am in DeleteUserDao");
		Session session=sessionFactory.openSession();
		for(int i=0;i<id.length;i++) {
			System.out.println(id[i]+"");
		 Users user=session.load(Users.class, id[i]);
		session.delete(user);
		}
		Transaction tt= session.beginTransaction();
		tt.commit();
		System.out.println("record deleted");
		return true;

}
}
