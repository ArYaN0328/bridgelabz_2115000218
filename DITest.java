
    import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}

public class ServiceA {
    public void perform() {
        System.out.println("ServiceA is working!");
    }
}

public class ServiceB {
    public void execute() {
        System.out.println("ServiceB is executing!");
    }
}

public class Application {
    @Inject
    private ServiceA serviceA;

    @Inject
    private ServiceB serviceB;

    public void run() {
        serviceA.perform();
        serviceB.execute();
    }
}

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register class: " + clazz.getSimpleName(), e);
        }
    }

    public void injectDependencies(Object target) {
        Class<?> clazz = target.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);

                if (dependency == null) {
                    try {
                        dependency = fieldType.getDeclaredConstructor().newInstance();
                        instances.put(fieldType, dependency);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to instantiate dependency: " + fieldType.getSimpleName(), e);
                    }
                }

                try {
                    field.setAccessible(true);
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency: " + field.getName(), e);
                }
            }
        }
    }
}

public class DITest {
    public static void main(String[] args) {
        DependencyInjector injector = new DependencyInjector();

        // Register services
        injector.register(ServiceA.class);
        injector.register(ServiceB.class);

        // Create Application instance
        Application app = new Application();

        // Inject dependencies
        injector.injectDependencies(app);

        // Run the application
        app.run();
    }
}

