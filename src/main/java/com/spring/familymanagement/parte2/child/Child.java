package com.spring.familymanagement.parte2.child;

public class Child {
    private Integer id;
    private String name;
    private Integer fatherId;
    private Integer motherId;

    public Child(Integer id, String name, Integer fatherId, Integer motherId) {
        this.id = id;
        this.name = name;
        this.fatherId = fatherId;
        this.motherId = motherId;
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

    public long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public long getMotherId() {
        return motherId;
    }

    public void setMotherId(Integer motherId) {
        this.motherId = motherId;
    }
}
