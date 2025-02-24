
public class MathOperations {
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulating a slow operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void fastMethod() {
        System.out.println("Fast method executed.");
    }
}

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimingProxy {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long startTime = System.nanoTime();
                    Object result = method.invoke(target, args);
                    long endTime = System.nanoTime();

                    long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                    System.out.println("[LOG] Method " + method.getName() + " executed in " + executionTime + " ms");
                    
                    return result;
                }
            }
        );
    }
}

public interface MathOperationsInterface {
    void slowMethod();
    void fastMethod();
}

public class MathOperations implements MathOperationsInterface {
    @Override
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulate a slow operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }
}

public class TimingProxyDemo {
    public static void main(String[] args) {
        // Create the real object
        MathOperationsInterface realMathOperations = new MathOperations();

        // Create a proxy to measure execution time
        MathOperationsInterface proxyMathOperations = TimingProxy.createProxy(realMathOperations, MathOperationsInterface.class);

        // Call methods and measure execution time
        proxyMathOperations.slowMethod();
        proxyMathOperations.fastMethod();
    }
}

