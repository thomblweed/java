package com.thomblweed.patterns.chain.methodchain;

public class CreatureModifier {
    private Creature creature;
    private CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public CreatureModifier getNext() {
        return this.next;
    }

    public void setNext(CreatureModifier next) {
        this.next = next;
    }

    public void add(CreatureModifier creatureModifier) {
        if (next != null) {
            next.add(creatureModifier);
        } else {
            next = creatureModifier;
        }
    }

    public void handle() {
        if (next != null)
            next.handle();
    }
}
