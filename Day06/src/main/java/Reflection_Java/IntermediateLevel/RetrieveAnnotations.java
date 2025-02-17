package Reflection_Java.IntermediateLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

public class RetrieveAnnotations {

    // Define the @Author annotation
    @Target(ElementType.TYPE)  // This means the annotation can only be applied to classes
    @Retention(RetentionPolicy.RUNTIME) // The annotation will be available at runtime
    public @interface Author {
        String name();
    }

    // Apply the @Author annotation to the MyClass class
    @Author(name = "John Doe")
    public static class MyClass {
        // Some class code
    }

    public static void main(String[] args) {
        // Get the class object of MyClass
        Class<?> myClass = MyClass.class;

        // Check if the @Author annotation is present on the class
        if (myClass.isAnnotationPresent(Author.class)) {
            // Get the @Author annotation instance from the class
            Author authorAnnotation = myClass.getAnnotation(Author.class);

            // Retrieve and print the value of the 'name' attribute
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No Author annotation present.");
        }
    }
}

