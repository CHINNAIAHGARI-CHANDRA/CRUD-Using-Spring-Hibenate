package org.jsp.springhibernatedemo.controller;

import java.util.Scanner;

import org.jsp.springhibernatedemo.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class DeleteUser {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_hib.xml");
		HibernateTemplate template=context.getBean(HibernateTemplate.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id delete");
		int id=sc.nextInt();
		User u=template.get(User.class, id);
		System.out.println(u);
		if(u!=null) {
			System.out.println("beforedelete");
			template.delete(u);
			System.out.println("after delete");
		}else {
			System.err.println("invalid id");
		}


	}

}
