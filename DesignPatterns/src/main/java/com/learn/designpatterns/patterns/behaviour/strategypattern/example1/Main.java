package com.learn.designpatterns.patterns.behaviour.strategypattern.example1;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategy classes
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using credit card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100);
        
        PaymentStrategy paypalPayment = new PayPalPayment("john.doe@example.com");
        cart.setPaymentStrategy(paypalPayment);
        cart.checkout(50);
    }
}