import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the main string
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        // Input the substring
        System.out.print("Enter the substring to search: ");
        String subString = scanner.nextLine();

        scanner.close();

        int count = countSubstringOccurrences(mainString, subString);
        System.out.println("The substring \"" + subString + "\" occurs " + count + " times in the main string.");
    }

    private static int countSubstringOccurrences(String mainString, String subString) {
        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); // Move index to avoid counting overlapping substrings
        }

        return count;
    }
}
