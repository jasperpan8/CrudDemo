package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "house")
public class House {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="house_name")
    private String house_name;

    @OneToMany(mappedBy = "house",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = false)
    private List<House_Person> house_people = new ArrayList<>();

    // No Arg Constructor and Arg Constructor
    public House() {
    }

    public House(String house_name) {
        this.house_name = house_name;
    }

    // getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public List<House_Person> getHouse_people() {
        return house_people;
    }

    public void setHouse_people(List<House_Person> house_people) {
        this.house_people = house_people;
    }

    public void addHousePeople(House_Person hp){
        this.house_people.add(hp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id && Objects.equals(house_name, house.house_name) && Objects.equals(house_people, house.house_people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, house_name, house_people);
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", house_name='" + house_name + '\'' +
                ", house_people=" + house_people +
                '}';
    }
}
