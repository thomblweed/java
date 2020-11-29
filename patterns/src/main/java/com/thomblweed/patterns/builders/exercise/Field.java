package com.thomblweed.patterns.builders.exercise;

public class Field {
    private String name;
    private String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
