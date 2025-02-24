
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxLength {
    int value(); // Defines the maximum allowed length
}

import java.lang.reflect.Field;

public class User {
    @MaxLength(10)  // Maximum username length = 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    private void validateMaxLength(Object obj, String value) {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (value.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Error: " + field.getName() + " exceeds max length of " + maxLength.value() + " characters"
                    );
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe");  //  Valid
            System.out.println("Username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername");  // Exceeds 10 characters, should throw an error
            System.out.println("Username: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

