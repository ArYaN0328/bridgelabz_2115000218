public class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14; // Total number of pens
        int totalStudents = 3; // Total number of students

        // Calculate pens per student and remaining pens
        int pensPerStudent = totalPens / totalStudents; // Division to get pens per student
        int remainingPens = totalPens % totalStudents; // Modulus to find remaining pens

        // Display the results
        System.out.println(
            "The Pen Per Student is " + pensPerStudent + 
            " and the remaining pen not distributed is " + remainingPens
        );
    }
}
