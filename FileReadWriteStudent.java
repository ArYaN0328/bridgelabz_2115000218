
import java.io.*;

public class FileReadWriteStudent {
    private static final String DATA_FILE = "students.dat";

    public static void storeStudentDetails(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(DATA_FILE))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student details stored successfully!");
        } catch (IOException e) {
            System.out.println("Error storing student details: " + e.getMessage());
        }
    }

    public static void retrieveStudentDetails() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(DATA_FILE))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Student Details: Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error retrieving student details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        storeStudentDetails(101, "John Doe", 3.8);
        retrieveStudentDetails();
    }
}

