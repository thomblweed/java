package com.thomblweed.patterns.composite.exercise;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(value);
    }
}
