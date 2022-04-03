package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestCURD {
	public static void main(String[] args) {
		addCustomer();
		// getAll();
		// updateStudent();
		// deleteStudent();
		// getData();

	}

	static void addCustomer() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Student s = new Student();
		s.setAge(24);
		s.setCity("KTM");
		s.setFname("nabin");
		s.setLname("joshi");
		s.setPhone("9840238186");

		session.save(s);
		session.getTransaction().commit();
		session.close();

	}

	// get all customers
	static void getAll() {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();

		//Criteria crt = (Criteria) session.getProperties();
//		List <Student> slist = crt.list();//select sql
//		slist.forEach(System.out::println);
	}

	// update Student
	static void updateStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, 1);
		s.setCity("DNG");
		s.setFname("Bamdev");
		s.setLname("bhatta");
		s.setAge(25);
		session.update(s);// update or wirte
		session.getTransaction().commit();
		session.close();

	}

	// delete student
	static void deleteStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Student s = (Student) session.get(Student.class, 102);
		session.delete(s);// delete sql

		session.getTransaction().commit();
		session.close();

	}

//HQL: (hibernate query language)
	static void getData() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		// Query hql = session.createQuery("FROM Student");
		Query hql = session.createQuery("FROM Student WHERE id=1");
		List<Student> slist = hql.list();
		slist.forEach(System.out::println);

	}
}