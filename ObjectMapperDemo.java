
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate through each entry in the map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    // Get the field from the class
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow modification of private fields
                    
                    // Set the field value
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
    }
}

public class User {
    private String name;
    private int age;

    public void displayUser() {
        System.out.println("User: " + name + ", Age: " + age);
    }
}

import java.util.HashMap;
import java.util.Map;

public class ObjectMapperDemo {
    public static void main(String[] args) {
        // Create a map with property values
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", "Alice");
        userData.put("age", 25);
        userData.put("extraField", "ignored"); // Field does not exist in User class

        // Convert map to User object
        User user = ObjectMapper.toObject(User.class, userData);

        // Display user details
        user.displayUser();
    }
}

