package com.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	public static void main(String[] args) {

		// oneToOne();
		//oneToMany();
		manyToMany();

	}

	// one-to-one mapping
	static void oneToOne() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Address adr = new Address("Nepal", "KTM", "state-3");
		session.save(adr);

		Employee emp = new Employee("bamdev", "bhatta", 23000, 23, adr);
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

	// one to many or many to one
	static void oneToMany() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Address adr = new Address("Nepal", "KTM", "state-3");
		session.save(adr);

		Employee emp = new Employee("bamdev", "bhatta", 23000, 23, adr);

		Phone p1 = new Phone();
		p1.setNumber("9811647853");
		p1.setType("NTC");
		p1.setEmployee(emp);
		session.save(p1);

		Phone p2 = new Phone();
		p2.setNumber("9840232938");
		p2.setType("N-CELL");
		p2.setEmployee(emp);
		session.save(p2);

		emp.setPhones(Arrays.asList(p1, p2));
		session.save(emp);
		
		session.getTransaction().commit();
		session.close();
	}
	//many to many 
	static void manyToMany() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address("Nepal", "DNG", "state-7");
		session.save(adr);
		
		Employee emp = new Employee("Bamdev", "Bhatta", 230999, 25, adr);
		session.save(emp);
		
		Phone p1 = new Phone();
		p1.setId(101);
		p1.setType("ITEL");
		p1.setNumber("393479387");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2 = new Phone();
		p2.setId(101);
		p2.setType("INDIA");
		p2.setNumber("23433434");
		p2.setEmployee(emp);
		session.save(p2);
		
		Department d = new Department();
		d.setName("Account");
		session.save(d);
		
		Department d1 = new Department();
		d1.setName("IT");
		session.save(d1);
		
		emp.setDeptList(Arrays.asList(d,d1));
		session.save(emp);
		emp.setPhones(Arrays.asList(p1,p2));
		session.save(emp);
		
		
		session.getTransaction().commit();
		session.close();
	}
}
