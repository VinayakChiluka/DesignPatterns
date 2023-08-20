package com.learn.designpatterns.solidprincipals.liskov_substitution_principle.examples1;

interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle drawn...");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square drawn...");
    }
}

public class Demo1 {
    static void drawShape(Shape s){
        s.draw();
    }
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape square = new Square();
        drawShape(rectangle);
        drawShape(square);
    }
}
