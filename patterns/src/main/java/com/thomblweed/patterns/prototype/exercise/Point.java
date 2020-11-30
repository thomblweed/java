package com.thomblweed.patterns.prototype.exercise;

public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public String toString() {
        return "{" + " x='" + x + "'" + ", y='" + y + "'" + "}";
    }
}
