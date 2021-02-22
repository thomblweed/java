package com.thomblweed.patterns.chain.methodchain;

public class DoubleAttackModifier extends CreatureModifier {

    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Doubling " + getCreature().getName() + "'s attack");
        int creatureAttack = getCreature().getAttack();
        getCreature().setAttack(creatureAttack *= 2);
        super.handle();
    }
}
