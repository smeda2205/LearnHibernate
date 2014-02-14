package com.learn.hibernate.mappings.onetoone;

import org.hibernate.Session;

import com.learn.hibernate.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Address address1 = new Address("Govt.Hospital Road", "Addanki", "A.P", "523201");
		Address address2 = new Address("Bhavani Center", "Addanki", "A.P", "523201");
		
		Student student1 = new Student("Srini",address1);
		Student student2 = new Student("Balaji", address2);
		
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		
		session.close();
	}
}
