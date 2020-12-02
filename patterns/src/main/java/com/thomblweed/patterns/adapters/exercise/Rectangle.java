package com.thomblweed.patterns.adapters.exercise;

public interface Rectangle {
    int getWidth();

    int getHeight();

    default int getArea() {
        return getWidth() * getHeight();
    }
}
