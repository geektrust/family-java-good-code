package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class MaternalAuntFinder implements IRelationFinder{
    @Override
    public List<Person> findRelatives(Person person) {
        List<Person> maternalAunts = new ArrayList<>();
        Person grandFather = person.getMother().getFather();
        for (Person child : grandFather.getChildren()) {
            if (child.equals(person) || child.getGender().equals(Gender.Male))
                continue;
            maternalAunts.add(child);
        }
        return maternalAunts;
    }
}
