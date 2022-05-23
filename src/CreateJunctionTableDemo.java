package com.example;

import com.example.entity.House;
import com.example.entity.House_Person;
import com.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateJunctionTableDemo {
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
            // create person and house object
            Person p = new Person();
            House h = new House();
            p.setName("Jason");
            h.setHouse_name("The Mansion");
            House_Person hp = new House_Person(p,h);

            // start transaction
            session.beginTransaction();
            System.out.println("Saving " + hp);

            // save house_person object
            session.save(hp);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
