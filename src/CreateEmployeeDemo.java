package com.example;

import com.example.entity.Department;
import com.example.entity.Department_Employee;
import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Department_Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            Employee employee = new Employee();
            employee.setName("Kai");
            session.beginTransaction();
            System.out.println("Saving Employee" + employee);
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Done");
        }finally{
            session.close();
            factory.close();
        }
    }
}
