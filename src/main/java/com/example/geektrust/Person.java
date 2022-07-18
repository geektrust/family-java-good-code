package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
	private String name;
	private Gender gender;
	private Person father;
	private Person mother;
	private Person spouse;
	private List<Person> children;

	public Person(String name,Gender gender) {
		this.name=name;
		this.gender=gender;
		this.father = null;
		this.mother =null;
		this.children=new ArrayList<>();
	}
	public Person(String name, Gender gender, Person father, Person mother) {
		this.name=name;
		this.gender=gender;
		this.father=father;
		this.mother=mother;
		this.children=new ArrayList<>();
	}
	public Person getSpouse() {
		return spouse;
	}
	public List<Person> getChildren() {
		return children;
	}
	public Person getMother() {
		return mother;
	}
	public String getName() {
		return name;
	}
	public Gender getGender() { return gender;}

	public Person getFather() {
		return this.father;
	}

	public String toString() {
		return this.getName();
	}

	public boolean addChild(Person child) {
		this.children.add(child);
		return true;
	}

	public void addSpouse(Person spouse) {
		this.spouse = spouse;
		spouse.spouse = this;
	}

	public List<Person> getChildren(Gender gender){
		List<Person> children =new ArrayList<>();
		for(Person child:this.getChildren())
		{
			if(!child.getGender().equals(gender))
				continue;
			children.add(child);
		}
		return children;
	}

	public List<Person> getSiblings(){
		if (this.getFather() ==null) {
			return null;
		}
		List<Person> siblings = new ArrayList<>();
		for(Person child:this.getFather().getChildren())
		{
			if(child.equals(this))
				continue;
			siblings.add(child);
		}
		return siblings;
	}

	public List<Person> getSiblings(Gender gender){
		List<Person> siblings = new ArrayList<>();
		if (this.getFather() ==null) {
			return siblings;
		}
		for(Person child:this.getFather().getChildren(gender))
		{
			if(child.equals(this))
				continue;
			siblings.add(child);
		}
		return siblings;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return name.equals(person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
