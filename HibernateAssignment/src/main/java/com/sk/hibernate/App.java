package com.sk.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sk.hibernate.entity.Gender;
import com.sk.hibernate.entity.School;
import com.sk.hibernate.util.HibernateUtil;


public class App {
    public static void main(String[] args) {
    	
    	// Inserting data in database
    	Session session=HibernateUtil.getSessionFactory().openSession();
    	Transaction tx= session.beginTransaction();
    	
    	School user=new School("Saranya","Kunaparaju","SK","test@com.in");
    	session.persist(user);
    	tx.commit();
    	System.out.println("Data is inserted"+user);
    	session.close();
    	
    	
    	//Reading
    	session=HibernateUtil.getSessionFactory().openSession();
    	
    	School userData =session.get(School.class, user.getId());
    	System.out.println("This data is fetched from DB"+userData);
    	session.close();
    	
    	//Update
    	session=HibernateUtil.getSessionFactory().openSession();
    	tx= session.beginTransaction();
    	userData.setFirstName("User Name Updated");
    	session.merge(userData);
    	System.out.println("Data is Updated"+userData);
    	session.close();
    	
    	//Delete
    	session=HibernateUtil.getSessionFactory().openSession();
    	tx= session.beginTransaction();
    	session.remove(userData);
    	tx.commit();
    	session.clear();
    	
    	System.out.println("User got Deleted"+ userData);
    	
    }
}
