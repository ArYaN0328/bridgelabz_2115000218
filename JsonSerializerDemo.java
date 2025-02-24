
import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Allow access to private fields
            
            try {
                String name = field.getName();
                Object value = field.get(obj);
                json.append("\"").append(name).append("\": ");

                // Handle different types of values
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
            } catch (IllegalAccessException e) {
                json.append("\"ERROR\"");
            }

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }
        
        json.append("}");
        return json.toString();
    }
}

public class Person {
    private String name;
    private int age;
    private boolean isEmployed;

    public Person(String name, int age, boolean isEmployed) {
        this.name = name;
        this.age = age;
        this.isEmployed = isEmployed;
    }
}

public class JsonSerializerDemo {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25, true);
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}

