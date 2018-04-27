package com.example.shadi.babycare.model.users;


public class Parent extends User {

    public Parent(String name, String surname, String city, int age, String email, String description) {
        this.setName(name);
        this.setSurname(surname);
        this.setBs(false);
        this.setAge(age);
        this.setCity(city);
        this.setDescription(description);
        this.setEmail(email);

    }

}