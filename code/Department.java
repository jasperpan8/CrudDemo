package com.example.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="department_name")
    private String department_name;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Department_Employee> department_employees = new ArrayList<>();

    public List<Department_Employee> getDepartment_employees() {
        return department_employees;
    }

    public void setDepartment_employees(List<Department_Employee> department_employees) {
        this.department_employees = department_employees;
    }

    public void addDepartmentEmployees(Department_Employee de){
        this.department_employees.add(de);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && department_name.equals(that.department_name) && Objects.equals(department_employees, that.department_employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department_name, department_employees);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department_name='" + department_name + '\'' +
                ", department_employees=" + department_employees +
                '}';
    }
}
