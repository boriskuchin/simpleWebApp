package ru.bvkuchin.hw4springjs.hw4springjs.repositories;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {

    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void shutDown() {
        if (sessionFactory != null) {
            sessionFactory.close();

        }
    }
}
