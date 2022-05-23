package com.example;

import com.example.entity.Department;
import com.example.entity.Department_Employee;
import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateJunctionTableDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Department_Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Employee e = new Employee();
            Department d = new Department();
            e.setName("Jeff");
            d.setDepartment_name("Human Resource");
            Department_Employee de = new Department_Employee();
            de.setEmployee(e);
            de.setDepartment(d);
            session.beginTransaction();
            System.out.println("Saving " + de);
            session.save(de);
            session.getTransaction().commit();
            System.out.println("Done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
