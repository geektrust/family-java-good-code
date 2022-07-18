package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class BrotherInLawFinder implements IRelationFinder{
    @Override
    public List<Person> findRelatives(Person person) {
        List<Person> brotherInLaws = new ArrayList<>();
        if(person == null) {
            return brotherInLaws;
        }
        if (person.getSpouse() != null) {
            brotherInLaws.addAll(person.getSpouse().getSiblings(Gender.Male));
        }
        for (Person sibling : person.getSiblings(Gender.Female)) {
            brotherInLaws.add(sibling.getSpouse());
        }
        return brotherInLaws;
    }
}
