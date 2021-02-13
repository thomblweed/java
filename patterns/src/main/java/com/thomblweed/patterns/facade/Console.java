package com.thomblweed.patterns.facade;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private List<Viewport> viewports = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(Viewport viewport) {
        viewports.add(viewport);
    }

    public void render() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (Viewport viewport : viewports) {
                    System.out.println(viewport.charAt(j, i));
                }
            }
        }
    }

    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(width, height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);
        return console;
    }
}
