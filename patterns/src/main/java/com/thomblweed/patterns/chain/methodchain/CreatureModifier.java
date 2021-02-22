package com.thomblweed.patterns.chain.methodchain;

public class CreatureModifier {
    private Creature creature;
    private CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
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
            handle();
    }
}
