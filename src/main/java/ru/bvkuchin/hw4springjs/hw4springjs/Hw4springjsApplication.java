package ru.bvkuchin.hw4springjs.hw4springjs;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bvkuchin.hw4springjs.hw4springjs.repositories.SessionFactoryUtils;

@SpringBootApplication
public class Hw4springjsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw4springjsApplication.class, args);

//		SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
//		sessionFactoryUtils.init();
//		System.out.println( sessionFactoryUtils.getSession());




	}

}
