import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;

        while (!quit) {
            // Display main menu options
            System.out.println("MAIN MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Appointments");
            System.out.println("4. Treatments");
            System.out.println("5. Quit");

            // Get user input for main menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    patientMenu(scanner);
                    break;
                case 2:
                    doctorMenu(scanner);
                    break;
                case 3:
                    appointmentMenu(scanner);
                    break;
                case 4:
                    treatmentMenu(scanner);
                    break;
                case 5:
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

    private static void patientMenu(Scanner scanner) {
        boolean exitPatientMenu = false;

        while (!exitPatientMenu) {
            // Display patient menu options
            System.out.println("\nPATIENT MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Register new patient");
            System.out.println("2. Display all patients");
            System.out.println("3. Modify a patient's record");
            System.out.println("4. Delete a patient's record");
            System.out.println("5. Main menu");

            // Get user input for patient menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Patient.registerNewPatient(scanner);
                    break;
                case 2:
                    Patient.displayAllPatients();
                    break;
                case 3:
                    modifyPatient(scanner);
                    break;
                case 4:
                    deletePatient(scanner);
                    break;
                case 5:
                    exitPatientMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void doctorMenu(Scanner scanner) {
        boolean exitDoctorMenu = false;

        while (!exitDoctorMenu) {
            // Display patient menu options
            System.out.println("\nDOCTOR MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Register new doctor");
            System.out.println("2. Display all doctors");
            System.out.println("3. Modify a doctor's record");
            System.out.println("4. Delete a doctor's record");
            System.out.println("5. Main menu");

            // Get user input for patient menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Doctor.registerNewDoctor(scanner);
                    break;
                case 2:
                    Doctor.displayAllDoctors();
                    break;
                case 3:
                    modifyDoctor(scanner);
                    break;
                case 4:
                    deleteDoctor(scanner);
                    break;
                case 5:
                    exitDoctorMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void appointmentMenu(Scanner scanner) {
        boolean exitAppointmentMenu = false;

        while (!exitAppointmentMenu) {
            // Display appointment menu options
            System.out.println("\nAPPOINTMENT MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Create new appointment");
            System.out.println("2. Display all appointments");
            System.out.println("3. Search appointments by patient name");
            System.out.println("4. Search appointments by doctor name");
            System.out.println("5. Modify an appointment");
            System.out.println("6. Delete an appointment");
            System.out.println("7. Main menu");

            // Get user input for appointment menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Appointment.createNewAppointment(scanner);
                    break;
                case 2:
                    Appointment.displayAllAppointments();
                    break;
                case 3:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    List<Appointment> patientAppointments = Appointment.getAppointmentsByPatientName(patientName);
                    displayAppointments(patientAppointments);
                    break;
                case 4:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    List<Appointment> doctorAppointments = Appointment.getAppointmentsByDoctorName(doctorName);
                    displayAppointments(doctorAppointments);
                    break;
                case 5:
                    System.out.print("Enter patient name to modify appointment: ");
                    String patientNameToModify = scanner.nextLine();
                    Appointment.modifyAppointmentByPatientName(patientNameToModify, scanner);
                    break;
                case 6:
                    System.out.print("Enter patient name to delete appointment: ");
                    String patientNameToDelete = scanner.nextLine();
                    Appointment.deleteAppointmentByPatientName(patientNameToDelete, scanner);

                    break;
                case 7:
                    exitAppointmentMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void treatmentMenu(Scanner scanner) {
        boolean exitTreatmentMenu = false;

        while (!exitTreatmentMenu) {
            // Display treatment menu options
            System.out.println("\nTREATMENT MENU");
            System.out.println("Choose one of the following options (enter a number):");
            System.out.println("1. Create new treatment");
            System.out.println("2. Display all treatments");
            System.out.println("3. Search treatments by patient name");
            System.out.println("4. Search treatments by doctor name");
            System.out.println("5. Modify a treatment");
            System.out.println("6. Delete a treatment");
            System.out.println("7. Main menu");

            // Get user input for treatment menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Treatments.createNewTreatment(scanner);
                    break;
                case 2:
                    Treatments.displayAllTreatments();
                    break;
                case 3:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    List<Treatments> patientTreatments = Treatments.getTreatmentsByPatientName(patientName);
                    displayTreatments(patientTreatments);
                    break;

                case 4:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    List<Treatments> doctorTreatments = Treatments.getTreatmentsByDoctorName(doctorName);
                    displayTreatments(doctorTreatments);
                    break;

                case 5:
                    modifyTreatment(scanner);
                    break;
                case 6:
                    deleteTreatment(scanner);
                    break;
                case 7:
                    exitTreatmentMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static void displayAppointments(List<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("Appointments found:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public static void displayTreatments(List<Treatments> treatments) {
        if (treatments.isEmpty()) {
            System.out.println("No treatments found.");
        } else {
            System.out.println("Treatments found:");
            for (Treatments treatment : treatments) {
                System.out.println(treatment);
            }
        }
    }

    // Method to modify a patient's record
    private static void modifyPatient(Scanner scanner) {
        System.out.print("Enter the full name of the patient to modify: ");
        String fullName = scanner.nextLine();

        // Get attribute to modify
        System.out.println("Choose attribute to modify:");
        System.out.println("1. Birthdate");
        System.out.println("2. Employer");
        System.out.println("3. Insurance company");
        System.out.print("Enter your choice: ");
        int attributeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String attributeToModify;
        switch (attributeChoice) {
            case 1:
                attributeToModify = "birthdate";
                break;
            case 2:
                attributeToModify = "work";
                break;
            case 3:
                attributeToModify = "insurance";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        System.out.print("Enter the new value: ");
        String newValue = scanner.nextLine();

        Patient.modifyPatient(fullName, attributeToModify, newValue);
    }

    // Method to delete a patient's record
    private static void deletePatient(Scanner scanner) {
        System.out.print("Enter the full name of the patient to delete: ");
        String fullName = scanner.nextLine();

        Patient.deletePatient(fullName);
    }

    public static void modifyDoctor(Scanner scanner) {
        System.out.print("Enter the full name of the doctor to modify: ");
        String fullName = scanner.nextLine();

        // Get new employed date
        System.out.print("Enter the new employed date (YYYY-MM-DD): ");
        String employedDate = scanner.nextLine();

        // Get new specialty
        System.out.print("Enter the new specialty: ");
        String specialty = scanner.nextLine();

        Doctor.modifyDoctor(fullName, employedDate, specialty);
    }

    public static void deleteDoctor(Scanner scanner) {
        System.out.print("Enter the full name of the doctor to delete: ");
        String fullName = scanner.nextLine();

        Doctor.deleteDoctor(fullName);
    }

    // Method to modify a treatment
    private static void modifyTreatment(Scanner scanner) {
        System.out.print("Enter the patient name of the treatment to modify: ");
        String patientName = scanner.nextLine();

        // Get attribute to modify
        System.out.println("Choose attribute to modify:");
        System.out.println("1. Medication");
        System.out.println("2. Description");
        System.out.print("Enter your choice: ");
        int attributeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline



        String attributeToModify;
        switch (attributeChoice) {
            case 1:
                attributeToModify = "medication";
                break;
            case 2:
                attributeToModify = "description";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        System.out.print("Enter the new value: ");
        String newValue = scanner.nextLine();

        Treatments.modifyTreatment(patientName, attributeToModify, newValue);
    }

    // Method to delete a treatment
    private static void deleteTreatment(Scanner scanner) {
        System.out.print("Enter the patient name of the treatment to delete: ");
        String patientName = scanner.nextLine();

        Treatments.deleteTreatment(patientName);
    }
}
