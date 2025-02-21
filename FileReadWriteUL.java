import java.io.*;

public class FileReadWriteUL {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void convertUppercaseToLowercase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion successful!");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        convertUppercaseToLowercase();
    }
}
