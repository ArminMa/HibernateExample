package com.mkyong;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mkyong.user.DBUser;
import com.mkyong.util.HibernateUtil;

public class ReadUser {

	public static void main(String[] args) {
		System.out.println("Reding users");

		// Create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		
		Query query = session.createQuery("from DBUSER");
		List<DBUser> users = query.list();
		for (DBUser user : users) {
			System.out.println("User Id: " + user.getUserId() + ", User Name: " + user.getUsername() + ", Created by: "
					+ user.getCreatedBy() + ", Creation date: " + user.getCreatedDate());
		}
		session.getTransaction().commit();
		sessionFactory.close();
	}

}
