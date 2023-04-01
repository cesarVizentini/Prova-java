package com.spring.familymanagement.parte2.parent;

public class Parent {
    private Integer id;
    private String name;

    public Parent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Parent(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
