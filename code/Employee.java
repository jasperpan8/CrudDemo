package com.example.cruddemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Department_Employee> department_employees = new ArrayList<>();

    public List<Department_Employee> getDepartment_employees() {
        return department_employees;
    }

    public void setDepartment_employees(List<Department_Employee> department_employees) {
        this.department_employees = department_employees;
    }

    public void addDepartmentEmployee(Department_Employee de){
        this.department_employees.add(de);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && name.equals(employee.name) && Objects.equals(department_employees, employee.department_employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department_employees);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department_employees=" + department_employees +
                '}';
    }
}
