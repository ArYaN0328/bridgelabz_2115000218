
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class Employer {
    private static final String IMAGE_FILE = "image.jpg";
    private static final String OUTPUT_FILE = "output.jpg";

    public static void convertImageToByteArray() {
        try (FileInputStream fis = new FileInputStream(IMAGE_FILE);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, bytesRead, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            writeByteArrayToImage(imageBytes);
            System.out.println("Image conversion successful!");
        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }

    public static void writeByteArrayToImage(byte[] imageBytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(OUTPUT_FILE)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error writing image file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        convertImageToByteArray();
    }
}

