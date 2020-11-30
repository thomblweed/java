package com.thomblweed.patterns.prototype.exercise;

public class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line(new Point(start), new Point(end));
    }

    @Override
    public String toString() {
        return "{" + " start='" + start + "'" + ", end='" + end + "'" + "}";
    }
}
