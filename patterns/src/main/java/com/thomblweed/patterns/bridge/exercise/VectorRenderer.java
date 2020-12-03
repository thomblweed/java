package com.thomblweed.patterns.bridge.exercise;

public class VectorRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}
