public class SpringSeason {

    // Method to check if the given month and day fall in the Spring season
    public static boolean isSpringSeason(int month, int day) {
        // Check if the date falls between March 20 and June 20
        if ((month == 3 && day >= 20 && day <= 31) || // March 20 to 31
            (month == 4 && day >= 1 && day <= 30) || // April
            (month == 5 && day >= 1 && day <= 31) || // May
            (month == 6 && day >= 1 && day <= 20)) { // June 1 to 20
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Ensure the program receives exactly two command-line arguments
        if (args.length != 2) {
            System.out.println("Please provide the month and day as command-line arguments.");
            return;
        }

        // Parse the month and day from the command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Validate the input
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid date. Please enter a valid month (1-12) and day (1-31).");
            return;
        }

        // Check if it's a Spring season and print the result
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }
}
