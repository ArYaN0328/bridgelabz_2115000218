public class DayOfWeek {
    public static void main(String[] args) {
        // Ensure correct number of arguments
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            return;
        }

        // Parse the input arguments
        int m = Integer.parseInt(args[0]); // month
        int d = Integer.parseInt(args[1]); // day
        int y = Integer.parseInt(args[2]); // year

        // Calculate y0 and m0 using the given formulas
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        // Calculate d0 (the day of the week)
        int d0 = (d + x + 31 * m0 / 12) % 7;

        // Print the result (the day of the week)
        System.out.println(d0);
    }
}
