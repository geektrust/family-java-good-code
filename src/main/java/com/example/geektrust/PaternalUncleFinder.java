package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class PaternalUncleFinder implements IRelationFinder{
    @Override
    public List<Person> findRelatives(Person person) {
        List<Person> paternalUncles = new ArrayList<>();
        Person grandFather = person.getFather().getFather();
        for (Person child : grandFather.getChildren()) {
            if (child.equals(person.getFather()) || child.getGender().equals(Gender.Female))
                continue;
            paternalUncles.add(child);
        }
        return paternalUncles;
    }
}
