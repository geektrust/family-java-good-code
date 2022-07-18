package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class PaternalAuntFinder implements IRelationFinder{
    @Override
    public List<Person> findRelatives(Person person) {
        List<Person> paternalAunt = new ArrayList<>();
        Person grandFather = person.getFather().getFather();
        for (Person child : grandFather.getChildren()) {
            if (child.getGender().equals(Gender.Male))
                continue;
            paternalAunt.add(child);
        }
        return paternalAunt;
    }
}
