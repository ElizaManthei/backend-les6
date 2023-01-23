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
    private Person partner;

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

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
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

        public List<Person> getGrandChildren(){
            List<Person> grandChildren = new ArrayList<>();
            for (Person p: this.children){
                for (Person gC : p.getChildren()){
                    grandChildren.add(gC);
                }
            }
            return grandChildren;
        }


        public void addPet(Pet pet) {
        this.pets.add(pet);
        }
    public void  addPartner(Person partner){
        this.partner = partner;
    }
    public List<Pet> getGrandChildrensPets(){
        List<Pet> pets = new ArrayList<>();
        List<Person> grandChildrens = getGrandChildren();
        for (Person gC : grandChildrens) {
            for (Pet p : gC.pets)
                pets.add(p);
        }
        return pets;
    }
    public List<Person> getFemaleCousins(){
    List<Person> cousins = new ArrayList<>();
    List<Person> motherSiblings = this.mother.getSiblings();
    List<Person> fatherSiblings = this.father.getSiblings();
    if(motherSiblings != null) {
        for (Person sib : motherSiblings) {
            for (Person c : sib.children) {
                if (c.getSex().equals("female")) {
                    cousins.add(c);
                }
            }
        }
    }
    if(fatherSiblings != null) {
        for (Person sib : fatherSiblings) {
            for (Person c : sib.children) {
                if (c.getSex().equals("female")) {
                    cousins.add(c);
                }
            }
        }
    }

        return cousins;
    }
    }
