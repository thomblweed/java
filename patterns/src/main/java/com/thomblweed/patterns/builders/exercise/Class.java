package com.thomblweed.patterns.builders.exercise;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private List<Field> fields = new ArrayList<>();

    public Class() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }
}
