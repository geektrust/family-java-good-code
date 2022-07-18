package com.example.geektrust;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {
    private static Family family;
    private static String st = new String();
    private Person king;
    private Person queen;
    private Map<String, Person> record;

    private Family(String[] inputFamily) throws IOException {
        king = new Person("Shan", Gender.Male);
        queen = new Person("Anga", Gender.Female);
        record = new HashMap<>();
        record.put("Shan", king);
        record.put("Anga", queen);
        king.addSpouse(queen);
        createFamily(inputFamily);
    }

    public static Family getFamilyInstance(String[] inputFamily) throws IOException {
        if (family == null) {
            family = new Family(inputFamily);
        }
        return family;
    }

    private void createFamily(String[] inputFamily) throws IOException {
        for (String st : inputFamily) {
            String[] command = st.split(" ");
            if (command.length == 4) {
                addRelation(command[0], command[1], command[2], command[3]);
            }
            if (command.length == 2) {
                addSpouse(command[0], command[1]);
            }
        }
    }

    public void addMember(String motherName, String name, String gender) {
        Person mother = findPerson(motherName);
        if (mother == null) {
            System.out.println(Constants.PERSON_NOT_FOUND);
            return;
        }
        if (mother.getGender().equals(Gender.Male)) {
            System.out.println(Constants.CHILD_ADDITION_FAILED);
            return;
        }
        Person father = mother.getSpouse();
        Person child = new Person(name, Gender.valueOf(gender), father, mother);
        record.put(name, child);
        mother.addChild(child);
        father.addChild(child);
        System.out.println(Constants.CHILD_ADDITION_SUCCEEDED);
        return;
    }

    public void addRelation(String fatherName, String motherName, String name, String gender) {
        Person father = findPerson(fatherName);
        Person mother = findPerson(motherName);
        Person child = new Person(name, Gender.valueOf(gender), father, mother);
        record.put(name, child);
        record.put(fatherName, father);
        record.put(motherName, mother);
        if (father != null)
            father.addChild(child);
        if (mother != null)
            mother.addChild(child);
    }

    public void addSpouse(String husbandName, String wifeName) {
        Person husband = findPerson(husbandName);
        Person wife = findPerson(wifeName);
        husband.addSpouse(wife);
    }

    private Person findPerson(String name) {
        for (Map.Entry<String, Person> entry : record.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void getRelationship(String name, Relation relation) {
        Person person = findPerson(name);
        if (person == null) {
            System.out.println(Constants.PERSON_NOT_FOUND);
            return;
        }
        switch (relation) {
            case Son:
                List<Person> sonList = person.getChildren(Gender.Male);
                print(sonList);
                break;
            case Daughter:
                List<Person> daughterList = person.getChildren(Gender.Female);
                print(daughterList);
                break;
            case Siblings:
                List<Person> siblingList = person.getSiblings();
                print(siblingList);
                break;
            default:
                IRelationFinder finder = getRelationFinder(relation);
                List<Person> relatives = finder.findRelatives(person);
                print(relatives);
                break;
        }
    }

    private IRelationFinder getRelationFinder(Relation relation) {
        switch (relation) {
            case Paternal_Uncle:
                return new PaternalUncleFinder();
            case Paternal_Aunt:
                return new PaternalAuntFinder();
            case Maternal_Aunt:
                return new MaternalAuntFinder();
            case Maternal_Uncle:
                return new MaternalUncleFinder();
            case Sister_In_Law:
                return new SisterInLawFinder();
            case Brother_In_Law:
                return new BrotherInLawFinder();
        }
        return null;
    }

    private void print(List<Person> persons) {
        if (persons == null || persons.size() == 0) {
            System.out.println(Constants.NONE);
            return;
        }
        for (Person person : persons) {
            System.out.print(person.getName() + " ");
        }
        System.out.println();
    }

}
