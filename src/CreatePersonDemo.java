package com.example;

import com.example.entity.House;
import com.example.entity.House_Person;
import com.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreatePersonDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(House.class)
                .addAnnotatedClass(House_Person.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // create person object
            Person person = new Person();
            person.setName("Jeff");

            // start transaction
            session.beginTransaction();
            System.out.println("Saving new person " + person);

            // save person object
            session.save(person);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        }finally{
            session.close();
            factory.close();
        }
    }
}
