package com.herbalife.dto;

public class CompanyDto {
    private String name;
    private String ceo;
    private int headcount;
    private boolean listed;

    public CompanyDto() {
    }

    public CompanyDto(String name, String ceo, int headcount, boolean listed) {
        this.name = name;
        this.ceo = ceo;
        this.headcount = headcount;
        this.listed = listed;
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

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }
}
