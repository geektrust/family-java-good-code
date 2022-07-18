package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class SisterInLawFinder implements IRelationFinder {
    @Override
    public List<Person> findRelatives(Person person) {
        List<Person> sistersInlaw = new ArrayList<>();
        if(person == null) {
            return sistersInlaw;
        }
        if (person.getSpouse() != null) {
            sistersInlaw.addAll(person.getSpouse().getSiblings(Gender.Female));
        }
        for (Person sibling : person.getSiblings(Gender.Male)) {
            sistersInlaw.add(sibling.getSpouse());
        }
        return sistersInlaw;
    }
}
