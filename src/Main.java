import java.util.Scanner;

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
            System.out.println("3. Main menu");

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
        // Placeholder method for creating a new appointment
        System.out.println("\nCreating a new appointment...");
        // Add actual logic to create appointment here
        System.out.println("Appointment created successfully!");
    }

    private static void registerNewPatient(Scanner scanner) {
        // Placeholder method for registering a new patient
        System.out.println("\nRegistering a new patient...");
        // Add actual logic to register patient here
        System.out.println("Patient registered successfully!");
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
        // Placeholder method for displaying all patients
        System.out.println("\nDisplaying all patients...");
        // Add actual logic to display all patients here
        System.out.println("Patients displayed successfully!");
    }
}
