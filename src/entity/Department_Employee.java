package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="department_employee")
public class Department_Employee {
    //define the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="e_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="d_id")
    private Department department;

    // Define Constructor
    public Department_Employee() {
    }

    public Department_Employee(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
    }

    // Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department_Employee{" +
                "id=" + id +
                ", employee=" + employee +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department_Employee that = (Department_Employee) o;
        return id == that.id && employee.equals(that.employee) && department.equals(that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, department);
    }
}
