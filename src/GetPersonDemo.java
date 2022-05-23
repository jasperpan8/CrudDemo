package com.example;

import com.example.entity.House;
import com.example.entity.House_Person;
import com.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetPersonDemo {
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
            // start transaction
            session.beginTransaction();

            // get the person object with Id = 6
            int theId = 6;
            Person p = session.get(Person.class, theId);
            System.out.println(p);
            System.out.println("Employee with Id"+ theId +" is " + p.getName());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
