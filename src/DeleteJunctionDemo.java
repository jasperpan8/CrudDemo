package com.example;

import com.example.entity.House;
import com.example.entity.House_Person;
import com.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteJunctionDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(House.class)
                .addAnnotatedClass(House_Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            int theId = 2;
            House_Person hp = session.get(House_Person.class,theId);
            session.delete(hp);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
