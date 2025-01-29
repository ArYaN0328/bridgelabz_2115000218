public class RemoveCharacter {
    public static void main(String[] args) {
        String input = "Hello World"; // Example input string
        char charToRemove = 'l'; // Character to remove

        // Call the method to remove the character
        String modifiedString = removeCharacter(input, charToRemove);

        // Output the modified string
        System.out.println("Modified String: \"" + modifiedString + "\"");
    }

    public static String removeCharacter(String str, char charToRemove) {
        // Use StringBuilder to construct the modified string
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // Append the character if it's not the one to remove
            if (ch != charToRemove) {
                result.append(ch);
            }
        }

        // Return the resulting string
        return result.toString();
    }
}
