package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void addParents() {
        Person father = new Person("Jan", "Jong", 40,"male");
        Person mother = new Person("Ana", "Jong", 40, "female");
        Person person = new Person("Laura", "Jong", 20,"female");

        person.addParents(mother, father);
        Person result = person.getFather();

        assertEquals(father, result);

    }

    @Test
    void childShouldBeAddedToPerson() {
        Person person = new Person("Laura", "Jong", 50,"female");
        Person child1 = new Person("Ana", "Jong", 20, "female");
        Person child2 = new Person("Jan", "Jong", 26,"male");

        person.addChild(child1);
        person.addChild(child2);
        Person result = person.getChildren().get(1);

        assertEquals(child2, result);

    }

    @Test
    void siblingShouldBeAddedToPerson() {
        Person person = new Person("Laura", "Jong", 45,"female");
        Person sibling1 = new Person("Ana", "Jong", 20, "female");
        Person sibling2 = new Person("Jan", "Jong", 26,"male");

        person.addSibling(sibling1);
        person.addSibling(sibling2);
        Person result = person.getSiblings().get(1);

        assertEquals(sibling2,result);
    }

    @Test
    void childrensChildrenShouldBeAddedToTheListOfGrandChildren() {
        Person mother = new Person("Laura", "Jong", 60,"female");
        Person child1 =  new Person("Jan", "Jong", 40,"male");
        Person child2  = new Person("Martha", "Jong", 38, "female");
        Person grandChild1 = new Person("Ana", "Jong", 20, "female");
        Person grandChild2 = new Person("Max", "Jong", 18, "male");

        List<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        List<Person> grandChildChild1 = new ArrayList<>();
        grandChildChild1.add(grandChild1);
        List<Person> grandChildChild2 = new ArrayList<>();
        grandChildChild2.add(grandChild2);
        List<Person> grandChildrens = new ArrayList<>();
        grandChildrens.add(grandChild1);
        grandChildrens.add(grandChild2);

        mother.setChildren(children);
        child1.setChildren(grandChildChild1);
        child2.setChildren(grandChildChild2);
        List<Person> result = mother.getGrandChildren();

        assertEquals(grandChildrens,result);


    }


    @Test
    void petShouldBeAddedToPerson() {
        Person person = new Person("Laura", "Jong", 20,"female");
        Pet pet1 = new Pet("Franio", 6,"kat");

        person.addPet(pet1);
        Pet result = person.getPets().get(0);

        assertEquals(pet1, result);
    }
    @Test
    void partnerShouldBeAddedToPerson(){
        Person person = new Person("Jan", "Jong", 40,"male");
        Person partner = new Person("Ana", "Jong", 40, "female");

        person.addPartner(partner);
        Person result = person.getPartner();

        assertEquals(partner,result);
    }
    @Test
    void grandChildrensPetsShouldBeAddedToTheList(){
        Person mother = new Person("Laura", "Jong", 60,"female");
        Person child1 =  new Person("Jan", "Jong", 40,"male");
        Person child2  = new Person("Martha", "Jong", 38, "female");
        Person grandChild1 = new Person("Ana", "Jong", 20, "female");
        Person grandChild2 = new Person("Max", "Jong", 18, "male");
        Pet pet1 = new Pet("Franio",6,"cat");
        Pet pet2 = new Pet("Olo", 3,"dog");
        List<Person> grandChildrens = new ArrayList<>();
        grandChildrens.add(grandChild1);
        grandChildrens.add(grandChild2);
        List<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        List<Person> grandChildChild1 = new ArrayList<>();
        grandChildChild1.add(grandChild1);
        List<Person> grandChildChild2 = new ArrayList<>();
        grandChildChild2.add(grandChild2);
        List<Pet> petsGrandChild1 = new ArrayList<>();
        petsGrandChild1.add(pet1);
        List<Pet> petsGrandChild2 = new ArrayList<>();
        petsGrandChild2.add(pet2);
        List<Pet> grandChildrensPets = new ArrayList<>();
        grandChildrensPets.add(pet1);
        grandChildrensPets.add(pet2);

        mother.setChildren(children);
        child1.setChildren(grandChildChild1);
        child2.setChildren(grandChildChild2);
        grandChild1.setPets(petsGrandChild1);
        grandChild2.setPets(petsGrandChild2);

        List<Pet> result = mother.getGrandChildrensPets();
        assertEquals(grandChildrensPets,result);


    }
    @Test
    void allFemaleCousinsShouldBeAddedToTheList(){
        Person aunt = new Person("Laura", "Jong", 60,"female");
        Person uncle =  new Person("Jan", "Jong", 40,"male");
        Person mother = new Person("Martha", "Jong", 38, "female");
        Person father = new Person("Henry", "Jong", 45,"male");
        Person auntsChild = new Person("Ana", "Jong", 20, "female");
        Person unclesChild= new Person("Max", "Jong", 18, "male");
        Person person = new Person("Hugo","Jong",7,"male");

        List<Person> auntsChildren = new ArrayList<>();
        auntsChildren.add(auntsChild);
        aunt.setChildren(auntsChildren);
        List<Person> unclesChildren = new ArrayList<>();
        unclesChildren.add(unclesChild);
        uncle.setChildren(unclesChildren);
        List<Person> mothersSiblings = new ArrayList<>();
        mothersSiblings.add(aunt);
        mothersSiblings.add(uncle);
        mother.setSiblings(mothersSiblings);
        List<Person> cousins = new ArrayList<>();
        cousins.add(auntsChild);


        person.setMother(mother);
        person.setFather(father);
        List<Person> result = person.getFemaleCousins();

        assertEquals(cousins,result);

    }
}