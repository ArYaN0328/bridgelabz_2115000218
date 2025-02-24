
public class Configuration {
    // Private static field
    private static String API_KEY = "ORIGINAL_KEY";

    // Getter method to check API_KEY value
    public static String getApiKey() {
        return API_KEY;
    }
}

import java.lang.reflect.Field;

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the Class object of Configuration
            Class<?> cls = Configuration.class;

            // Get the private static field "API_KEY"
            Field field = cls.getDeclaredField("API_KEY");

            // Make the field accessible
            field.setAccessible(true);

            // Modify the static field value
            field.set(null, "NEW_API_KEY");

            // Print modified value
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

