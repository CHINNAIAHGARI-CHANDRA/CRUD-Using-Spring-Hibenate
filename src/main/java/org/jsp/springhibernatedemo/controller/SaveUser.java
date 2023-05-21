package org.jsp.springhibernatedemo.controller;

import java.util.Scanner;

import org.jsp.springhibernatedemo.dao.UserDao;
import org.jsp.springhibernatedemo.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class SaveUser {
    static Scanner s=new Scanner(System.in);
	 public static void main(String[] args) {
			System.out.println("1. register user");
//			System.out.println("2 login");
			System.out.println("3 Update user");
			System.out.println("4 delete user");
			System.out.println("5 find user");
			System.out.println("enter any number");
			int choice=s.nextInt();
			switch (choice) {
			case 1:{
				register();
				break;
			}
//			case 2:{
//				login();
//				break;
//			}
			case 3:{
				update();
				break;
			}
			case 4:{
				delete();
				break;
			}
			case 5:{
				find();
				break;
			}
			default:{
				
			System.out.println(" invalid choice");
				break;
			}
			}
		}


		private static void delete() {
			ApplicationContext context=new ClassPathXmlApplicationContext("spring_hib.xml");
			UserDao dao=context.getBean("dao",UserDao.class);
			System.out.println("enter your id");
			int id=s.nextInt();
		boolean b=dao.deleteUser(id);
		System.out.println(b);
		
	}


		private static void find() {
			ApplicationContext context=new ClassPathXmlApplicationContext("spring_hib.xml");
			UserDao dao=context.getBean("dao",UserDao.class);
			System.out.println("enter your id");
			int id=s.nextInt();
		User u=dao.findUser(id);
		if (u!=null) {
			System.out.println("name :"+u.getName());
			System.out.println("email :"+u.getEmail());
			System.out.println("phone :"+u.getPhone());
			
		} else {
         System.err.println("invalid id");
		}
		
	}


		private static void update() {
			ApplicationContext context=new ClassPathXmlApplicationContext("spring_hib.xml");
			UserDao dao=context.getBean("dao",UserDao.class);
			System.out.println("enter your id");
			int id=s.nextInt();
			User u=new User();
			u.setId(id);
			u.setName("chinna");
			u.setEmail("b@gmail.com");
			u.setPhone(9999);
			dao.updateUser(u);
			
		
	}


		private static void register() {
			ApplicationContext context=new ClassPathXmlApplicationContext("spring_hib.xml");
			UserDao dao=context.getBean("dao",UserDao.class);
			User u=new User();
			u.setName("abc");
			u.setEmail("ab@gmail.com");
			u.setPhone(9999);
			dao.saveUser(u);
		
	}


		

}
