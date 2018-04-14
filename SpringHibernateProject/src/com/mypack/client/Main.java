package com.mypack.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypack.service.UserServicesImpl;

public class Main {

	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	UserServicesImpl dao = context.getBean("userServiesImpl", UserServicesImpl.class);
	System.out.println(dao.getUser());
	}

	

}
