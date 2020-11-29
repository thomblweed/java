package com.thomblweed.patterns.builders.exercise;

public class CodeBuilder {
    private Class classVar = new Class();
    private final String newLine = System.lineSeparator();

    public CodeBuilder(String className) {
        classVar.setName(className);
    }

    public CodeBuilder addField(String name, String type) {
        Field field = new Field(type, name);
        classVar.addField(field);
        return this;
    }

    private String toStringImpl() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("public class %s%s", classVar.getName(), newLine));

        stringBuilder.append(openBrace());

        for (Field field : classVar.getFields())
            stringBuilder.append(
                    String.format("  public %s %s;%s", field.getName(), field.getType(), newLine));

        stringBuilder.append(closeBrace());

        return stringBuilder.toString();
    }

    private String openBrace() {
        return String.format("{%s", newLine);
    }

    private String closeBrace() {
        return "}";
    }

    @Override
    public String toString() {
        return toStringImpl();
    }
}
