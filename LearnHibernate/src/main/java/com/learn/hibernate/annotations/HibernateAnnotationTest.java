package com.learn.hibernate.annotations;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateAnnotationTest {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1L);
		user.setName("Srini");
		user.setJoinDate(new Date());
		user.setAddress("Addanki");
		user.setDescription("Sr. Soft Engineer");
		
		/**
		 * Using Hibernate API
		 * 
		 *  1. Create a Session Factory
		 *  2. Create a session from the session factory.
		 *  3. Use the session to save model objects.
		 */
		
		// Step 1:
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Step 2:
		Session session = sessionFactory.openSession();
		
		// Step 3:
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		sessionFactory.close();
	}
}
