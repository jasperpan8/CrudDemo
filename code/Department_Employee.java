package com.example.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Department_Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="e_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="d_id")
    private Department department;

    public Department_Employee(Employee employee, Department department) {
        this.employee = employee;
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
