package com.thomblweed.patterns.adapters.exercise;

public class SquareToRectangleAdapter implements Rectangle {
    private Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.getSide();
    }

    @Override
    public int getHeight() {
        return square.getSide();
    }
}
