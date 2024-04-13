import java.util.*;

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
            System.out.println("4. Display all patients");
            System.out.println("5. Display all doctors");
            System.out.println("6. Display all appointments");
            System.out.println("7. Search appointments by patient name");
            System.out.println("8. Search appointments by doctor name");
            System.out.println("9. Main menu");

            // Get user input for reception menu option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Appointment.createNewAppointment(scanner);
                    break;

                case 2:
                    Patient.displayAllPatients();
                    break;
                case 3:
                    Doctor.displayAllDoctors();
                    break;
                case 4:
                    Patient.registerNewPatient(scanner);
                    break;
                case 5:
                    Doctor.registerNewDoctor(scanner);
                    break;
                case 6:
                    Appointment.displayAllAppointments();
                    break;
                case 7:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    List<Appointment> patientAppointments = Appointment.getAppointmentsByPatientName(patientName);
                    displayAppointments(patientAppointments);
                    break;
                case 8:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    List<Appointment> doctorAppointments = Appointment.getAppointmentsByDoctorName(doctorName);
                    displayAppointments(doctorAppointments);
                    break;
                case 9:
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
            System.out.println("2. Display all treatments");
            System.out.println("3. Search treatments by patient name");
            System.out.println("4. Search treatments by doctor name");
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
                    exitDoctor = true;
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
}
