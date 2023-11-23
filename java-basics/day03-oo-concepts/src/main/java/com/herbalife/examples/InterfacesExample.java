package com.herbalife.examples;

public class InterfacesExample {
    public static void main(String[] args) {
        Square sq = new Square();
        sq.draw();
        Shape sq2 = new Square();
        sq2.draw();
    }
}

interface Shape {
    void draw();
}
interface Figure {}

class Square implements Shape, Figure { //class Square : Shape, Figure
    public void draw() { //public void draw()
        System.out.println("Drawing square");
    }
}
