package com.herbalife.model;

public class Company {
    private String id;
    private String name;
    private String ceo;
    private int headcount;

    public Company() {
    }

    public Company(String id, String name, String ceo, int headcount) {
        this.id = id;
        this.name = name;
        this.ceo = ceo;
        this.headcount = headcount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }
}
