package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person mother, father;

    @BeforeEach
    void setUp() {
        mother = new Person("Mother", Gender.Female);
        father = new Person("father", Gender.Male);
        father.addSpouse(mother);
    }

    @Test
    void addChild() {
        Person child = new Person("Child 1", Gender.Female);
        mother.addChild(child);
        List<Person> children = mother.getChildren();
        assertFalse(children.isEmpty());

        List<Person> boys = mother.getChildren(Gender.Male);
        assertTrue(boys.isEmpty());
    }

    @Test
    void addSpouse() {
        Person shan = new Person("shan", Gender.Male);
        Person anga = new Person("anga", Gender.Male);
        shan.addSpouse(anga);
        assertEquals("shan", anga.getSpouse().getName());
    }

    @Test
    void getSiblings() {
        Person child1 = new Person("Child 1", Gender.Female,father,mother);
        Person child2 = new Person("Child 2", Gender.Male, father,mother);
        Person child3 = new Person("Child 3", Gender.Female, father,mother);
        mother.addChild(child1);
        mother.addChild(child2);
        mother.addChild(child3);
        father.addChild(child1);
        father.addChild(child2);
        father.addChild(child3);
        List<Person> allSiblings = child1.getSiblings();

        assertEquals(2, allSiblings.size());
    }
}