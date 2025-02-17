package Reflection_Java.BasicLevel;
import java.lang.reflect.Constructor;

public class CreateObjectUsingReflection {

    // Inner Student class
    public static class Student {
        private String name;
        private int age;

        // Constructor
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method to display student information
        public void display() {
            System.out.println("Student Name: " + name);
            System.out.println("Student Age: " + age);
        }
    }

    public static void main(String[] args) {
        try {
            // Correctly using the fully qualified class name for the inner class
            Class<?> studentClass = Class.forName("com.BasicLevel.CreateObjectUsingReflection$Student");

            // Get the constructor of the Student class that takes two parameters (String, int)
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Dynamically create an instance of Student using the constructor
            Object studentObject = constructor.newInstance("John Doe", 20);

            // Cast the object to Student and call the display method
            Student student = (Student) studentObject;
            student.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
