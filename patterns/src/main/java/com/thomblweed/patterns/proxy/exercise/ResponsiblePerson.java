package com.thomblweed.patterns.proxy.exercise;

public class ResponsiblePerson extends Person {
    public ResponsiblePerson(Person person) {
        super(person.getAge());
    }

    @Override
    public String drink() {
        if (super.getAge() < 18) {
            return "too young";
        }
        return super.drink();
    }

    @Override
    public String drive() {
        if (this.getAge() < 16) {
            return "too young";
        }
        return super.drive();
    }

    @Override
    public String drinkAndDrive() {
        return "dead";
    }
}
