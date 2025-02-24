
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField {
    String name(); // Defines the JSON key
}

public class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age; // No annotation → Ignored in JSON

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {
    public static String toJson(Object obj) {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true); // Allow access to private fields
                JsonField annotation = field.getAnnotation(JsonField.class);
                
                try {
                    Object value = field.get(obj);
                    jsonMap.put(annotation.name(), value.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return jsonMap.toString().replace("=", ": "); // Convert map to JSON format
    }
}

public class JsonSerializationDemo {
    public static void main(String[] args) {
        User user = new User("JohnDoe", "john@example.com", 25);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}

