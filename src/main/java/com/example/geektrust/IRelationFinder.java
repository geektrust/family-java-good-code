package com.example.geektrust;

import java.util.List;

public interface IRelationFinder {
    /**
     * Given a person the implementaion of this interface should return the relation of the Person
     * @param person
     * @return
     */
    List<Person> findRelatives(Person person);
}
