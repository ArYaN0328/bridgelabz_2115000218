
class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next; // Pointer to the next node

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head; // Head of the linked list

    // Insert at the beginning
    public void insertAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Insert at the end
    public void insertAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Insert at a specific position (1-based index)
    public void insertAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position <= 1) {
            insertAtBeginning(rollNumber, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range. Adding at the end.");
            insertAtEnd(rollNumber, name, age, grade);
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student temp = head, prev = null;
        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }

        prev.next = temp.next; // Remove node from list
    }

    // Search by Roll Number
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Update Grade by Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated Grade for Roll No " + rollNumber + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all students
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding students
        studentList.insertAtEnd(101, "Alice", 20, 'A');
        studentList.insertAtEnd(102, "Bob", 21, 'B');
        studentList.insertAtBeginning(100, "Charlie", 19, 'A');
        studentList.insertAtPosition(103, "David", 22, 'C', 2);

        // Display all records
        System.out.println("\nAll Student Records:");
        studentList.displayAll();

        // Searching for a student
        System.out.println("\nSearching for Roll No 102:");
        studentList.searchByRollNumber(102);

        // Updating a grade
        System.out.println("\nUpdating Grade for Roll No 103:");
        studentList.updateGrade(103, 'B');

        // Display all records after update
        System.out.println("\nAll Student Records After Grade Update:");
        studentList.displayAll();

        // Deleting a student
        System.out.println("\nDeleting Roll No 101:");
        studentList.deleteByRollNumber(101);

        // Display all records after deletion
        System.out.println("\nAll Student Records After Deletion:");
        studentList.displayAll();
    }
}

