package com.herbalife.model;

public class Company {
    private String id;
    private String name;
    private String ceo;
    private int headcount;
    private boolean listed;

    public Company() {
    }

    public Company(String id, String name, String ceo, int headcount, boolean listed) {
        this.id = id;
        this.name = name;
        this.ceo = ceo;
        this.headcount = headcount;
        this.listed = listed;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
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
