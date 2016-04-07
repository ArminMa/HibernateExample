package com.mkyong;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class CreateUser {
	
	public static void main(String[] args) {
		
		System.out.println("Creating user");
		
		// Create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		
		DBUser user = new DBUser();
		user.setUserId(1);
		user.setUsername("HibernateUser");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
		sessionFactory.close();
	}
}
