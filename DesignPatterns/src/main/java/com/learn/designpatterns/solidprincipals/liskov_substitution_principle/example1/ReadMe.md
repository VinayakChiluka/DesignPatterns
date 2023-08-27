Certainly! Let's consider an example using Java to illustrate the Liskov Substitution Principle.

Suppose we have a class hierarchy for shapes:

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}
```

In this example, the `Shape` class is the superclass, and `Circle` and `Square` are subclasses. They all have a `draw` method that prints the name of the shape being drawn.

Now, let's consider the following code that demonstrates Liskov Substitution Principle:

```java
public class Main {
    static void drawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        drawShape(circle); // Output: Drawing a circle
        drawShape(square); // Output: Drawing a square
    }
}
```

In this example, you can see that we're able to interchangeably pass both `Circle` and `Square` objects to the `drawShape` method without any issues. This adheres to the Liskov Substitution Principle because the behavior of the subclasses (`Circle` and `Square`) doesn't violate the behavior expected from the superclass (`Shape`). The subclasses are true extensions of the superclass's behavior.

If the subclasses introduced unexpected behaviors, violated contracts, or caused errors when used interchangeably with the superclass, it would violate the Liskov Substitution Principle.