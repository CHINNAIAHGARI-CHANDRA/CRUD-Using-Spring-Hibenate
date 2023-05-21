package org.jsp.springhibernatedemo.controller;

import java.util.Scanner;

import org.jsp.springhibernatedemo.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UpdateUser {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_hib.xml");
		HibernateTemplate template = context.getBean(HibernateTemplate.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id update");
		int id = sc.nextInt();
		System.out.println("enter your name,email,phone");
		String name = sc.next();
		String email = sc.next();
		long phone = sc.nextLong();
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setId(id);
		template.update(u);
	}

}
