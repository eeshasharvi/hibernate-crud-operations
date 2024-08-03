package com.example.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class operationcontroller {
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int ch;
		
		do {
			
		    displaymenu();
			ch = Integer.parseInt(scr.nextLine());
			switch (ch) {
			case 1:
				insertion();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				getall();
				break;
			case 5:
				getbyid();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("invalid operation");
				break;
			}
		}
		while(ch>0);
	}
	
	private static void getbyid() {
		Scanner scr = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("Enter id:");
		 int id=scr.nextInt();
		 Transaction t = s.beginTransaction();
		 operation a = s.get(operation.class, id);
		 if(a!=null) {
			 System.out.println("id:" +a.getId());
			 
			 System.out.println("id:" +a.getName());
			 
			 System.out.println("id:" +a.getEmail());
			 
		 }
		 else {
			 System.out.println("not available");
		 }
		 t.commit();
		
	}

	private static void getall() {
		Scanner scr = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		List<operation> li = s.createQuery("from akshaya", operation.class).list();
		t.commit();
		
		for(operation a:li) {
			System.out.println("name: "+a.getId());
			
			System.out.println("name: "+a.getName());
			
			System.out.println("name: "+a.getEmail());
			
		}
			
		}

	private static void update() {
		Scanner scr = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("Enter id:");
		 int id=scr.nextInt();
		 Transaction t = s.beginTransaction();
		 operation a = s.get(operation.class, id);
		 if (a!=null) {
			 System.out.println("enter new name");
			 String name =scr.next();
			 
			 System.out.println("enter new email");
			 String email =scr.next();
			 
			 a.setName(name);
			 
			 a.setEmail(email);
			 
			 s.update(a);
			 
			 t.commit();
			 
			 System.out.println("successfully updated");
		 }
		 else {
			 System.out.println("error");
		 }
		
	}

	private static void delete() {
		Scanner scr = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id: ");
		int id = scr.nextInt();
		Transaction t = s.beginTransaction();
		operation a = s.get(operation.class, id);
		s.delete(a);
		t.commit();
	    
	    System.out.println("successfully inserted");
		
	}

	private static void insertion() {
		
		Scanner scr = new Scanner(System.in);
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id: ");
		int id = scr.nextInt();
		Transaction t = s.beginTransaction();
		operation a = new operation();
		
	    System.out.println("Enter Name");
	    String name = scr.nextLine();
	    a.setName(name);
	    
	    System.out.println("Enter email");
	    String email = scr.nextLine();
	    a.setName(email);
	    
	    s.save(a);
	    
	    t.commit();
	    
	    System.out.println("successfully deleted");
		
	}

	private static void displaymenu() {
		
		System.out.println("___");
		System.out.println("\t1.insertion");
		System.out.println("\t2.delete");
		System.out.println("\t3.update");
		System.out.println("\t4.getall");
		System.out.println("\t5.getbyid");
		System.out.println("\t6.exit");
	}

}
