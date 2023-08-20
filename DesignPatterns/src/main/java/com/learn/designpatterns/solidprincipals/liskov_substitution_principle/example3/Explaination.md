Sure, here are examples illustrating each of the concepts you mentioned:

1. **Behavior Preservation**:

   Suppose we have a `Vehicle` superclass with a method `startEngine()` that prints "Engine started." The behavior preservation principle would imply that a subclass like `ElectricCar` should not override `startEngine()` to print "Engine started" because that would be misleading and contradictory. Instead, the subclass could implement a method like `turnOnMotor()` to convey the same concept in a way consistent with its functionality.

   ```java
   class Vehicle {
       void startEngine() {
           System.out.println("Engine started.");
       }
   }

   class ElectricCar extends Vehicle {
       void turnOnMotor() {
           System.out.println("Motor turned on.");
       }
   }
   ```

2. **Invariants**:

   Let's consider a `BankAccount` superclass that ensures the account balance is never negative. A subclass `SavingsAccount` must maintain this invariant by not allowing withdrawals that would result in a negative balance.

   ```java
   class BankAccount {
       protected double balance;

       void deposit(double amount) {
           balance += amount;
       }

       void withdraw(double amount) {
           if (balance >= amount) {
               balance -= amount;
           }
       }
   }

   class SavingsAccount extends BankAccount {
       @Override
       void withdraw(double amount) {
           if (balance - amount >= 0) { // Maintaining the invariant
               balance -= amount;
           }
       }
   }
   ```

3. **Postconditions**:

   Consider a `MathOperation` superclass with a method `divide(int a, int b)` that guarantees that if `b` is not zero, the division result will be calculated. A subclass `SafeMathOperation` can extend this behavior and further ensure that the division only occurs if `b` is positive.

   ```java
   class MathOperation {
       double divide(int a, int b) {
           if (b != 0) {
               return (double) a / b;
           } else {
               throw new IllegalArgumentException("Cannot divide by zero.");
           }
       }
   }

   class SafeMathOperation extends MathOperation {
       @Override
       double divide(int a, int b) {
           if (b > 0) { // Stronger postcondition
               return super.divide(a, b);
           } else {
               throw new IllegalArgumentException("Divisor must be positive.");
           }
       }
   }
   ```

4. **Preconditions**:

   Imagine a `FileReader` superclass with a method `readFile(String filename)` that reads a file's contents. A subclass `SecureFileReader` could ensure that only files from a certain directory can be read.

   ```java
   class FileReader {
       String readFile(String filename) {
           // Read the file and return its content
       }
   }

   class SecureFileReader extends FileReader {
       String readFile(String filename) {
           if (isValidFile(filename)) { // Weaker precondition
               return super.readFile(filename);
           } else {
               throw new SecurityException("Access denied.");
           }
       }

       private boolean isValidFile(String filename) {
           // Check if the file is allowed to be read
       }
   }
   ```

Remember, these examples are simplified for illustration purposes and may not cover all possible scenarios. In real-world software development, adhering to these principles helps create robust and maintainable class hierarchies.