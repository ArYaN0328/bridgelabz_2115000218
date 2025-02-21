
import java.io.*;

public class FileReadWrite3 {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFileBuffered = "destination_buffered.txt";
        String destinationFileUnbuffered = "destination_unbuffered.txt";
        String userDataFile = "user_data.txt";

        // Using Buffered Streams for Efficient File Copy
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
            long endTime = System.nanoTime();
            System.out.println("Buffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found!");
        } catch (IOException e) {
            System.out.println("Error reading or writing the file.");
        }

        // Using Unbuffered Streams for Comparison
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {
            
            int data;
            long startTime = System.nanoTime();
            
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            
            long endTime = System.nanoTime();
            System.out.println("Unbuffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found!");
        } catch (IOException e) {
            System.out.println("Error reading or writing the file.");
        }
        
        // Read User Input and Write to a File
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(userDataFile)) {
            
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            
            System.out.println("User data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error reading input or writing to file.");
        }
    }
}

