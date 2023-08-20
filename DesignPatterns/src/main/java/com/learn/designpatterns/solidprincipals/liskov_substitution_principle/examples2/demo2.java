package com.learn.designpatterns.solidprincipals.liskov_substitution_principle.examples2;

class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}



public class demo2 {

    static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        Bird penguin = new Penguin();

        makeBirdFly(bird);     // Output: Bird is flying
        makeBirdFly(penguin);  // Throws UnsupportedOperationException
    }
}
