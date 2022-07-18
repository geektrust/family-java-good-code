package com.example.geektrust;

public enum Gender {
    Male("Male"),
    Female("Female");

    final String name;
    private Gender(String gender) {
        this.name = gender;
    }
}
