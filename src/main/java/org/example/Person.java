package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Person{

    private String name;
    private int age;
    private  String middleName;
    private  String lastName;
    private  String sex;

    private  Person mother;
    private  Person father;
    private  List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, String lastName, int age,String sex ) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.sex = sex;
    }
    public Person(String name, String middleName, String lastName, int age, String sex){
        this.name = name;
        this.age = age;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addParents(Person mother, Person father){
        this.setMother(mother);
        this.setFather(father);
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addSibling(Person person){
            this.siblings.add(person);
        }

        public List<Person> getGrandChildren(Person person){
            List<Person> grandChildrens = new ArrayList<>();
            for (Person p: person.children){
                for (Person gC : p.getChildren()){
                    grandChildrens.add(gC);
                }
            }
            return grandChildrens;
        }


        public void addPet(Pet pet) {
        this.pets.add(pet);
        }
    }
