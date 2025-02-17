package Reflection_Java.AdvancedLevel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Define the Greeting interface
interface Greeting {
    void sayHello();
}

// Implement the InvocationHandler that intercepts method calls
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;  // The original object to delegate method calls to

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before executing it
        System.out.println("Logging: Calling method " + method.getName());

        // Call the actual method on the target object
        return method.invoke(target, args);
    }
}

// Concrete implementation of the Greeting interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create an instance of the original class (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create a dynamic proxy for the Greeting interface
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        // Call methods on the proxy object, which will be intercepted and logged
        proxyGreeting.sayHello();
    }
}
