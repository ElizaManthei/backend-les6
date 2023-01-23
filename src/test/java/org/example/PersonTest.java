package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void addParents() {
        Person father = new Person("Jan", "Jong", 40,"man");
        Person mother = new Person("Ana", "Jong", 40, "woman");
        Person person = new Person("Laura", "Jong", 20,"woman");

        person.addParents(mother, father);
        Person result = person.getFather();

        assertEquals(father, result);

    }

    @Test
    void childShouldBeAddedToPerson() {
        Person person = new Person("Laura", "Jong", 50,"woman");
        Person child1 = new Person("Ana", "Jong", 20, "woman");
        Person child2 = new Person("Jan", "Jong", 26,"man");

        person.addChild(child1);
        person.addChild(child2);
        Person result = person.getChildren().get(1);

        assertEquals(child2, result);

    }

    @Test
    void siblingShouldBeAddedToPerson() {
        Person person = new Person("Laura", "Jong", 45,"woman");
        Person sibling1 = new Person("Ana", "Jong", 20, "woman");
        Person sibling2 = new Person("Jan", "Jong", 26,"man");

        person.addSibling(sibling1);
        person.addSibling(sibling2);
        Person result = person.getSiblings().get(1);

        assertEquals(sibling2,result);
    }

    @Test
    void childrensChildrenShouldBeAddedToTheListOfGrandchildren() {
        Person mother = new Person("Laura", "Jong", 60,"woman");
        Person child1 =  new Person("Jan", "Jong", 40,"man");
        Person child2  = new Person("Martha", "Jong", 38, "woman");
        Person grandChild1 = new Person("Ana", "Jong", 20, "woman");
        Person grandChild2 = new Person("Max", "Jong", 18, "woman");
        List<Person> grandChildrens = new ArrayList<>();
        List<Person> children = new ArrayList<>();
        List<Person> grandChildChild1 = new ArrayList<>();
        List<Person> grandChildChild2 = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        grandChildChild1.add(grandChild1);
        grandChildChild2.add(grandChild2);
        grandChildrens.add(grandChild1);
        grandChildrens.add(grandChild2);

        mother.setChildren(children);
        child1.setChildren(grandChildChild1);
        child2.setChildren(grandChildChild2);
        List<Person> result = mother.getGrandChildren(mother);

        assertEquals(grandChildrens,result);


    }


    @Test
    void petShouldBeAddedToPerson() {
        Person person = new Person("Laura", "Jong", 20,"woman");
        Pet pet1 = new Pet("Franio", 6,"kat");

        person.addPet(pet1);
        Pet result = person.getPets().get(0);

        assertEquals(pet1, result);
    }
}