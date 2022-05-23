package com.example;

import com.example.entity.Department;
import com.example.entity.Department_Employee;
import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {

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
            
            // get the employee object
            int theId = 6;
            Employee e = session.get(Employee.class, theId);
            System.out.println("Deleting Employee " +e);
            
            // delete the employee Id 6
            session.delete(e);
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
            
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
