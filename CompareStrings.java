public class CompareStrings {
    public static void main(String[] args) {
        String string1 = "apple";  // Example String 1
        String string2 = "banana"; // Example String 2

        // Call the custom compare method
        int result = compareLexicographically(string1, string2);

        if (result < 0) {
            System.out.println("\"" + string1 + "\" comes before \"" + string2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + string1 + "\" comes after \"" + string2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + string1 + "\" and \"" + string2 + "\" are equal");
        }
    }

    public static int compareLexicographically(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLength = Math.min(len1, len2);

        // Compare each character in the strings
        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 < char2) {
                return -1; // str1 comes before str2
            } else if (char1 > char2) {
                return 1; // str1 comes after str2
            }
        }

        // If all characters are the same in the compared portion, compare the lengths
        if (len1 < len2) {
            return -1; // str1 is shorter, so it comes first
        } else if (len1 > len2) {
            return 1; // str1 is longer, so it comes after
        }

        return 0; // The strings are equal
    }
}
