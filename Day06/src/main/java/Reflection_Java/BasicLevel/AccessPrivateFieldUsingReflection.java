package Reflection_Java.BasicLevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class AccessPrivateFieldUsingReflection {
    public static void main(String[] args) {
        try {
            // Create an instance of the Person class
            Person person = new Person(25);

            // Display the initial value of the 'age' field
            System.out.println("Before modification:");
            person.displayAge();

            // Access the 'age' field using reflection
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);  // Allow access to private field

            // Modify the value of the 'age' field using reflection
            ageField.set(person, 30);  // Set 'age' field to 30

            // Display the modified value of the 'age' field
            System.out.println("After modification:");
            person.displayAge();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

