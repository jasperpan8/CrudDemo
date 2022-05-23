package com.example;

import com.example.entity.Department;
import com.example.entity.Department_Employee;
import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateJunctionTableDemo {
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
            // create Employee Object and Department Object
            Employee e = new Employee();
            Department d = new Department();
            e.setName("Jeff");
            d.setDepartment_name("Human Resource");
            
            // put the employee and department into Department_Employee class object
            Department_Employee de = new Department_Employee(e,d);
            // de.setEmployee(e);
            // de.setDepartment(d);
            
            // start a transaction
            session.beginTransaction();
            System.out.println("Saving " + de);
            
            // save Department_Employee Object
            session.save(de);
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
