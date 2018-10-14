package com.javaArchitect.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javaArchitect.models.Organization;

public class TestMain {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
			addAnnotatedClass(Organization.class).buildSessionFactory();
	Session session = factory.getCurrentSession();
	try {
		/*Organization org = new Organization();
		org.setCompanyName("Florida Blue");
		org.setEmployeeCount(10000);
		//org.setId(12);
		org.setPostalCode("1234");;
		org.setSlogan("Insurance for everyone");
		org.setYearOfIncorporation(1998);
		session.beginTransaction();
		session.save(org);
		session.getTransaction().commit();
		 System.out.println("done");*/
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}finally {
		factory.close();
	}
}
}
