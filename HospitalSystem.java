
import java.util.ArrayList;

// Doctor class (Can have multiple patients)
class Doctor {
    private String name;
    private String specialization;
    private ArrayList<Patient> patients;  // Association: A doctor can consult multiple patients

    // Constructor
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Get doctor details
    public String getName() {
        return name;
    }

    // Add a patient to the doctor
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Consultation method to show communication between doctor and patient
    public void consult(Patient patient) {
        System.out.println(name + " (Doctor, " + specialization + ") is consulting " + patient.getName() + " (Patient).");
    }

    // Display all patients of the doctor
    public void displayPatients() {
        System.out.println(name + "'s Patients:");
        for (Patient patient : patients) {
            System.out.println("  - " + patient.getName());
        }
    }
}

// Patient class (Can consult multiple doctors)
class Patient {
    private String name;
    private ArrayList<Doctor> doctors;  // Association: A patient can consult multiple doctors

    // Constructor
    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Get patient details
    public String getName() {
        return name;
    }

    // Add a doctor to the patient
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Display all doctors of the patient
    public void displayDoctors() {
        System.out.println(name + "'s Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  - " + doctor.getName());
        }
    }
}

// Hospital class (Contains doctors and patients, demonstrating association)
class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // Constructor
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add doctor to hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add patient to hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display hospital details
    public void displayHospitalDetails() {
        System.out.println("\nHospital: " + hospitalName);
        System.out.println("\nDoctors:");
        for (Doctor doctor : doctors) {
            doctor.displayPatients();  // Display patients of each doctor
        }
        System.out.println("\nPatients:");
        for (Patient patient : patients) {
            patient.displayDoctors();  // Display doctors of each patient
        }
    }
}

// Main class to demonstrate association and communication
public class HospitalSystem {
    public static void main(String[] args) {
        // Creating a hospital
        Hospital myHospital = new Hospital("City Hospital");

        // Creating doctors
        Doctor drSmith = new Doctor("Dr. Smith", "Cardiology");
        Doctor drJohnson = new Doctor("Dr. Johnson", "Neurology");

        // Creating patients
        Patient patientAlice = new Patient("Alice");
        Patient patientBob = new Patient("Bob");

        // Adding doctors and patients to the hospital
        myHospital.addDoctor(drSmith);
        myHospital.addDoctor(drJohnson);
        myHospital.addPatient(patientAlice);
        myHospital.addPatient(patientBob);

        // Adding patients to doctors (Association)
        drSmith.addPatient(patientAlice);
        drSmith.addPatient(patientBob);
        drJohnson.addPatient(patientAlice);

        // Adding doctors to patients (Association)
        patientAlice.addDoctor(drSmith);
        patientAlice.addDoctor(drJohnson);
        patientBob.addDoctor(drSmith);

        // Display hospital details (Show associations)
        myHospital.displayHospitalDetails();

        // Simulating consultations (Communication)
        drSmith.consult(patientAlice);  // Dr. Smith consulting Alice
        drJohnson.consult(patientAlice); // Dr. Johnson consulting Alice
    }
}

