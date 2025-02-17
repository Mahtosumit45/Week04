package Reflection_Java.AdvancedLevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

// Step 2: Implement the DI container
class SimpleDIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    // Registers an instance of a class
    public <T> void register(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    // Gets an instance of the specified class and injects dependencies
    public <T> T getInstance(Class<T> clazz) {
        try {
            // If an instance of the class already exists, return it
            if (instances.containsKey(clazz)) {
                return (T) instances.get(clazz);
            }

            // Otherwise, create a new instance and inject dependencies
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Inject dependencies into fields annotated with @Inject
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true); // Make private fields accessible

                    // Get the dependency type (class) from the field
                    Class<?> fieldType = field.getType();

                    // Get the dependency instance from the container
                    Object dependency = instances.get(fieldType);

                    if (dependency != null) {
                        // Inject the dependency into the field
                        field.set(instance, dependency);
                    } else {
                        // If the dependency is not found, throw an exception
                        throw new RuntimeException("No instance found for " + fieldType.getName());
                    }
                }
            }

            // Register the created instance for future use
            instances.put(clazz, instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
        }
    }
}

// Step 3: Define classes with dependencies

// Class that requires a dependency
class ServiceA {
    public void performAction() {
        System.out.println("ServiceA performing action...");
    }
}

// Class that requires injection of ServiceA
class ServiceB {
    @Inject
    private ServiceA serviceA;

    public void performAction() {
        System.out.println("ServiceB performing action...");
        serviceA.performAction();  // Calls ServiceA's method
    }
}

// Step 4: Demonstration
public class DependencyInjection {
    public static void main(String[] args) {
        // Step 4.1: Create the DI container
        SimpleDIContainer container = new SimpleDIContainer();

        // Step 4.2: Register services in the container
        container.register(ServiceA.class, new ServiceA());

        // Step 4.3: Get an instance of ServiceB, which will automatically inject ServiceA
        ServiceB serviceB = container.getInstance(ServiceB.class);

        // Step 4.4: Call the method on ServiceB, which will use the injected ServiceA
        serviceB.performAction();
    }
}

