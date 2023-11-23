package com.herbalife;

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCeo() {
        return ceo;
    }

    public int getHeadcount() {
        return headcount;
    }

    public boolean isListed() {
        return listed;
    }
}
