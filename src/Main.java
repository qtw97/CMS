import java.util.*;
import java.io.*;

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
            System.out.println("4. Main menu");
    
            // Get user input for reception menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    createNewAppointment(scanner);
                    break;
                case 2:
                    registerNewPatient(scanner);
                    break;
                case 3:
                    registerNewDoctor(scanner);
                    break;
                case 4:
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
            System.out.println("2. All patients");
            System.out.println("3. Main menu");

            // Get user input for doctor menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNewTreatment(scanner);
                    break;
                case 2:
                    displayAllPatients();
                    break;
                case 3:
                    exitDoctor = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void createNewAppointment(Scanner scanner) {
        // Gather information for the new appointment
        System.out.println("\nCreating a new appointment...");
    
        System.out.print("Enter patient's name: ");
        String patientName = scanner.nextLine();
    
        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine();
    
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
    
        System.out.print("Enter appointment time (HH:MM): ");
        String appointmentTime = scanner.nextLine();
    
        // Add logic to save the appointment or perform any other necessary actions
        // For demonstration, we'll just print the details
        System.out.println("Appointment created successfully!");
        System.out.println("Patient: " + patientName);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
    }
    

    private static void registerNewPatient(Scanner scanner) {
        // Gather information for the new patient
        System.out.println("\nRegistering a new patient...");
    
        System.out.print("Enter patient's first name: ");
        String firstName = scanner.nextLine();
    
        System.out.print("Enter patient's last name: ");
        String lastName = scanner.nextLine();
    
        System.out.print("Enter patient's date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
    
        System.out.print("Enter patient's employer: ");
        String employer = scanner.nextLine();
    
        System.out.print("Enter patient's insurance company: ");
        String insuranceCompany = scanner.nextLine();
    
        // Create a new Patient object with the provided information
        Patient newPatient = new Patient(firstName, lastName, dateOfBirth, employer, insuranceCompany);
        newPatient.saveToFile();
              
        System.out.println("Patient registered successfully!");
        System.out.println(newPatient.toString());
    }
      
    private static void registerNewDoctor(Scanner scanner) {
        // Gather information for the new doctor
        System.out.println("\nAdding a new doctor...");
        
        System.out.print("Enter doctor's first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter doctor's last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter doctor's date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        
        System.out.print("Enter doctor's employed date (YYYY-MM-DD): ");
        String employedDate = scanner.nextLine();
        
        System.out.print("Enter doctor's specialty: ");
        String specialty = scanner.nextLine();
        
        // Create a new Doctor object with the provided information
        Doctor newDoctor = new Doctor(firstName, lastName, dateOfBirth, employedDate, specialty);
        
        // Save doctor information to a text file
        newDoctor.saveToFile();
        
        System.out.println("Doctor added successfully!");
        System.out.println(newDoctor.toString());
    }
    

    private static void createNewTreatment(Scanner scanner) {
        // Display list of patients to choose from
        System.out.println("\nDoctor Menu - Create New Treatment");
        System.out.println("Select a patient to create a treatment:");

        // This array would ideally be populated from the Patient.txt file
        String[] patients = {
            "Lisa Davis",
            "Robert Parker",
            "Sarah Johnson",
            "Michael Smith",
            "Emily Brown"
        };

        for (int i = 0; i < patients.length; i++) {
            System.out.println((i + 1) + ". " + patients[i]);
        }

        // Get user input for patient selection
        System.out.print("Enter patient number: ");
        int patientIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (patientIndex >= 1 && patientIndex <= patients.length) {
            String selectedPatient = patients[patientIndex - 1];
            System.out.println("Selected patient: " + selectedPatient);

            // Placeholder logic for creating treatment
            System.out.println("Enter medication for treatment:");
            String medication = scanner.nextLine();

            System.out.println("Enter description for treatment:");
            String description = scanner.nextLine();

            // Simulate treatment creation using TreatmentCreator class
            TreatmentCreator.createTreatment("Dr. John Smith", selectedPatient, medication, description);
        } else {
            System.out.println("Invalid patient selection.");
        }
    }

    private static void displayAllPatients() {
        System.out.println("\nDisplaying all patients...");
    
        try (BufferedReader reader = new BufferedReader(new FileReader("Patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the patient file: " + e.getMessage());
        }
    }
    
}
