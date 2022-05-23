package com.example;

import com.example.entity.Department;
import com.example.entity.Department_Employee;
import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Department_Employee.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();
            
            // get employee object
            Employee e = new Employee();
            e.setName("Jay");
            e.setId(2);
            
            // update the employee object
            session.saveOrUpdate(e);
            System.out.println(e);
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
            
        }finally {
            session.close();
            factory.close();
        }
    }
}
