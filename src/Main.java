import java.util.*;
import java.io.*;
import java.time.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;

        while (!quit) {
            // Display main menu options
            System.out.println("MAIN MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Reception");
            System.out.println("2. Doctor");
            System.out.println("3. Quit");

            // Get user input for main menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    receptionMenu(scanner);
                    break;
                case 2:
                    doctorMenu(scanner);
                    break;
                case 3:
                    quit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void receptionMenu(Scanner scanner) {
        boolean exitReception = false;

        while (!exitReception) {
            // Display reception menu options
            System.out.println("\nRECEPTION MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Create new appointment");
            System.out.println("2. Register new patient");
            System.out.println("3. Register new doctor");
            System.out.println("4. Display all appointments");
            System.out.println("5. Main menu");

            // Get user input for reception menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Appointment.createNewAppointment(scanner);
                    break;
                case 2:
                    Patient.registerNewPatient(scanner);
                    break;
                case 3:
                    Doctor.registerNewDoctor(scanner);
                    break;
                case 4:
                    displayAllAppointments();
                    break;
                case 5:
                    exitReception = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void doctorMenu(Scanner scanner) {
        boolean exitDoctor = false;

        while (!exitDoctor) {
            // Display doctor menu options
            System.out.println("\nDOCTOR MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Create new treatment");
            System.out.println("2. Display all patients");
            System.out.println("3. Display all doctors");
            System.out.println("4. Display all treatments");
            System.out.println("5. Main menu");

            // Get user input for doctor menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                Treatments.createNewTreatment(scanner);
                    break;
                case 2:
                    displayAllPatients();
                    break;
                case 3:
                    displayAllDoctors();
                    break;
                case 4:
                    displayAllTreatments();
                    break;
                case 5:
                    exitDoctor = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayAllPatients() {
        System.out.println("\nDisplaying all patients...");
        List<Patient> patients = Patient.readFromFile("Patients.txt");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }

    private static void displayAllDoctors() {
        System.out.println("\nDisplaying all doctors...");
        List<Doctor> doctors = Doctor.readFromFile("Doctors.txt");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }

    private static void displayAllAppointments() {
        System.out.println("\nDisplaying all appointments...");
        List<Appointment> appointments = Appointment.readFromFile("Appointments.txt");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.toString());
        }
    }

    public static void displayAllTreatments() {
        System.out.println("\nDisplaying all treatments...");
        List<Treatments> treatments = Treatments.readFromFile("Treatments.txt");
        for (Treatments treatment : treatments) {
            System.out.println(treatment.toString());
        }
    }
    

}
