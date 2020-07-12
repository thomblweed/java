package com.thomblweed.microservices.limitsservice.bean;

public class LimitsConfiguration {
    private int maximum;
    private int minimum;

    protected LimitsConfiguration() {

    }

    public LimitsConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public int getMaximum() {
        return this.maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return this.minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
}
