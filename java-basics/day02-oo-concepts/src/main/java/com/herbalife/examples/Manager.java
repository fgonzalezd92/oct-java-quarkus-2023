package com.herbalife.examples;

//class Manager : Employee {}
public class Manager extends Employee {
    private int level;

    //public Manager(...) : base(name) {}
    public Manager(String name, int level) {
        super(name);
        this.level = level;
    }

    public void work(int hours) {
        super.work(hours);
        System.out.println("Manager %s works %s hours".formatted(this.getName(), hours));
    }

    public void fileTax() {

    }
}
