package com.thomblweed.patterns.chain.methodchain;

public class Creature {
    private String name;
    private int attack, defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", attack='" + getAttack() + "'" +
            ", defense='" + getDefense() + "'" +
            "}";
    }
}
