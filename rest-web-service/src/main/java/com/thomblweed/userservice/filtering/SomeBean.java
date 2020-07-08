package com.thomblweed.userservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

// dynamic filtering annotation
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String value1;
    private String value2;

    // static filtering example
    // filtering to the class that effects all endpoints using this class
    @JsonIgnore
    private String value3;

    public SomeBean(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1() {
        return this.value1;
    }

    public String getValue2() {
        return this.value2;
    }

    public String getValue3() {
        return this.value3;
    }

	public void setValue1(String value1) {
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }    
}
