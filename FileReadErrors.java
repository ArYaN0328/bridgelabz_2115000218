
import java.io.*;

public class FileReadErrors {
    private static final String FILE_NAME = "largefile.txt";

    public static void readErrorLines() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readErrorLines();
    }
}

