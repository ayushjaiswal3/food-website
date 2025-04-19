package com.zosh.Online.Food.Ordering;

import com.zosh.Online.Food.Ordering.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineFoodOrderingApplication {

	public static void main(String[] args) {

//		User user = new User();
//		user.setFullName("John");
//		System.out.println("Users Full Name is : " + user.getFullName());


		SpringApplication.run(OnlineFoodOrderingApplication.class, args);
	}

}
