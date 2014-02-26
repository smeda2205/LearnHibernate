package com.learn.hibernate.annotations.embeddingobjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("First User");
		
		Address address1 = new Address();
		address1.setStreet("Street1");
		address1.setCity("City1");
		address1.setState("State1");
		address1.setPincode("Pincode1");
		
		person.setHomeAddress(address1);
		person.setOfficeAddress(address1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		sessionFactory.close();
	}
}
