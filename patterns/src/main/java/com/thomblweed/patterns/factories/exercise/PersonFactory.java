package com.thomblweed.patterns.factories.exercise;

import java.util.ArrayList;
import java.util.List;

public class PersonFactory {
    private List<Person> people = new ArrayList<>();

    public Person createPerson(String name) {
        Person person = new Person(people.size(), name);
        people.add(person);

        return person;
    }
}
