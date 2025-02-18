package Annotations_Java.Examples;

// Step 1: Define the Animal class with a makeSound() method
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Step 2: Define the Dog class that overrides makeSound() method
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Step 3: Instantiate the Dog and call makeSound() method
public class AnimalOverride {
    public static void main(String[] args) {
        // Instantiate Dog object
        Animal myDog = new Dog();

        // Call the makeSound() method, which will call Dog's version
        myDog.makeSound(); // Output: Dog barks
    }
}

