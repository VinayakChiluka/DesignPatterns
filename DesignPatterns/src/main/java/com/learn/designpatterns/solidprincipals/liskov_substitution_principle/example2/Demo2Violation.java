package com.learn.designpatterns.solidprincipals.liskov_substitution_principle.example2;

class Vehicle {
    void startEngine() {
        System.out.println("Starting engine");
    }
}

class ElectricCar extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Starting electric car");
    }
}




public class Demo2Violation {
    static void operateVehicle(Vehicle vehicle) {
        vehicle.startEngine();
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle electricCar = new ElectricCar();

        operateVehicle(vehicle);     // Output: Starting engine
        operateVehicle(electricCar);  // Output: Starting electric car
    }

}
