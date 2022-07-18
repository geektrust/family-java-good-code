package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class MaternalUncleFinder implements IRelationFinder{
    @Override
    public List<Person> findRelatives(Person person) {
        List<Person> maternalUncles = new ArrayList<>();
        Person grandFather = person.getMother().getFather();
        for (Person child : grandFather.getChildren()) {
            if (child.getGender().equals(Gender.Female))
                continue;
            maternalUncles.add(child);
        }
        return maternalUncles;
    }
}
