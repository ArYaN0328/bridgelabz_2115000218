public class ToggleCase {
    public static void main(String[] args) {
        String input = "Hello World!"; // Example string
        StringBuilder toggledString = new StringBuilder();

        // Iterate over each character in the string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Toggle the case using conditional checks
            if (Character.isUpperCase(currentChar)) {
                toggledString.append(Character.toLowerCase(currentChar));
            } else if (Character.isLowerCase(currentChar)) {
                toggledString.append(Character.toUpperCase(currentChar));
            } else {
                // Non-alphabet characters remain unchanged
                toggledString.append(currentChar);
            }
        }

        // Output the toggled case string
        System.out.println(toggledString.toString());
    }
}
