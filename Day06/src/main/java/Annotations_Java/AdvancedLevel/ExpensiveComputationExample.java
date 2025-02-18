import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.METHOD)  // The annotation will be used on methods
@interface CacheResult {
    // You could add additional parameters if needed, but for simplicity, we leave it empty.
}

// Step 2: Create a class with computationally expensive methods
class ExpensiveComputation {

    private static final Map<String, Object> cache = new HashMap<>();  // Cache to store results

    // Step 3: Apply @CacheResult to an expensive method
    @CacheResult
    public int computeFactorial(int n) {
        System.out.println("Computing factorial for " + n);  // To show when the method is being computed

        if (n == 0) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // Step 4: Create a method that handles the caching mechanism
    public static Object cacheMethod(Object obj, Method method, Object[] args) throws Exception {
        // Generate a unique key for the method based on the arguments
        String key = method.getName() + "_" + args[0];  // Assume only one parameter for simplicity

        // If the result is in the cache, return it
        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for " + key);
            return cache.get(key);
        }

        // Otherwise, invoke the method to compute the result
        Object result = method.invoke(obj, args);

        // Store the result in the cache
        cache.put(key, result);

        return result;
    }
}

// Step 5: Simulate calling the method with caching
public class ExpensiveComputationExample {
    public static void main(String[] args) {
        try {
            ExpensiveComputation computation = new ExpensiveComputation();

            // Reflection setup to call the computeFactorial method
            Method computeMethod = ExpensiveComputation.class.getMethod("computeFactorial", int.class);

            // Calling the method with a sample input
            System.out.println("Factorial of 5: " + cacheMethod(computation, computeMethod, new Object[]{5}));
            System.out.println("Factorial of 5: " + cacheMethod(computation, computeMethod, new Object[]{5}));  // This should return the cached result

            // Calling the method with another input
            System.out.println("Factorial of 6: " + cacheMethod(computation, computeMethod, new Object[]{6}));
            System.out.println("Factorial of 6: " + cacheMethod(computation, computeMethod, new Object[]{6}));  // This should return the cached result

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Step 6: Use reflection to invoke method with caching logic
    private static Object cacheMethod(Object obj, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(CacheResult.class)) {
            return ExpensiveComputation.cacheMethod(obj, method, args);  // Call the cache method
        } else {
            return method.invoke(obj, args);  // Call the method normally
        }
    }
}
