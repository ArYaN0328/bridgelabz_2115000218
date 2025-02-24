
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheResult {
}

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CacheProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + "(" + (args != null ? args[0] : "") + ")";
            
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for: " + key);
                return cache.get(key);
            }

            Object result = method.invoke(target, args);
            cache.put(key, result);
            return result;
        }

        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new CacheProxy(target)
        );
    }
}

public interface ExpensiveOperations {
    @CacheResult
    long fibonacci(int n);
}

public class ExpensiveOperationsImpl implements ExpensiveOperations {
    @Override
    public long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

public class CacheDemo {
    public static void main(String[] args) {
        ExpensiveOperations operations = CacheProxy.create(new ExpensiveOperationsImpl(), ExpensiveOperations.class);

        System.out.println("Computing Fibonacci(10)...");
        System.out.println("Result: " + operations.fibonacci(10));

        System.out.println("\nComputing Fibonacci(10) again...");
        System.out.println("Result: " + operations.fibonacci(10)); // Cached result
    }
}

