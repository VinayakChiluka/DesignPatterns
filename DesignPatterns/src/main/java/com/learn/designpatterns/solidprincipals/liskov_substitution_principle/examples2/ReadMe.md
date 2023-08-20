Here's an example that demonstrates a violation of the Liskov Substitution Principle:

Suppose we have a class hierarchy for birds:

```java
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
```

In this example, the `Bird` class has a `fly` method, and the `Penguin` class is a subclass that overrides the `fly` method to indicate that penguins can't fly.

Now let's consider the following code that demonstrates a violation of the Liskov Substitution Principle:

```java
public class Main {
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
```

In this example, even though `Penguin` is a subclass of `Bird`, it violates the Liskov Substitution Principle because it introduces an unexpected behavior. When we try to make a penguin fly, it throws an exception because penguins cannot fly. This violates the expectation that a subclass should be able to replace its superclass without altering the correctness of the program.

In this case, the introduction of an exception behavior in the subclass that is not part of the superclass's behavior leads to a violation of the Liskov Substitution Principle.