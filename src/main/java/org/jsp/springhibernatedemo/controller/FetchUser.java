package org.jsp.springhibernatedemo.controller;

import java.util.Scanner;

import org.jsp.springhibernatedemo.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class FetchUser {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_hib.xml");
		HibernateTemplate template=context.getBean(HibernateTemplate.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		User u=template.get(User.class, id);
		if(u!=null) {
			System.out.println("name :"+ u.getName());
			System.out.println("phone :"+u.getPhone());
			System.out.println("email :"+u.getEmail());
//			System.out.println("id :"u.getId());
		}else {
			System.err.println("invalid id");
		}

	}

}
