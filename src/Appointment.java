import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appointment {
    private String patientName;
    private static String doctorName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Appointment(String patientName, String doctorName, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                '}';
    }
    

    // Method to save appointment information to a text file
    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Appointments.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
    
            // Write appointment details to the file
            printWriter.println(patientName + "," + doctorName + "," + appointmentDate + "," + appointmentTime);
    
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving appointment information: " + e.getMessage());
        }
    }    

    // Method to create a new appointment
        public static void createNewAppointment(Scanner scanner) {
        // Display list of patients to choose from
        System.out.println("\nCreating a new appointment...");
        List<Patient> patients = Patient.readFromFile("Patients.txt");
        List<Doctor> doctors = Doctor.readFromFile("Doctors.txt");

        // Display patient names for selection
        System.out.println("Select a patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getFullName());
        }

        // Get user input for patient selection
        System.out.print("Enter patient number: ");
        int patientIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (patientIndex < 1 || patientIndex > patients.size()) {
            System.out.println("Invalid patient selection.");
            return;
        }

        Patient selectedPatient = patients.get(patientIndex - 1);

        // Display doctor names for selection
        System.out.println("\nSelect a doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getFullName());
        }

        // Get user input for doctor selection
        System.out.print("Enter doctor number: ");
        int doctorIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (doctorIndex < 1 || doctorIndex > doctors.size()) {
            System.out.println("Invalid doctor selection.");
            return;
        }

        Doctor selectedDoctor = doctors.get(doctorIndex - 1);

        // Gather information for the new appointment
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDateString = scanner.nextLine();
        LocalDate appointmentDate = LocalDate.parse(appointmentDateString);

        System.out.print("Enter appointment time (HH:MM): ");
        String appointmentTimeString = scanner.nextLine();
        LocalTime appointmentTime = LocalTime.parse(appointmentTimeString);

        // Create a new Appointment object and save it to file
        Appointment appointment = new Appointment(selectedPatient.getFullName(), selectedDoctor.getFullName(),
                appointmentDate, appointmentTime);
        appointment.saveToFile();
    }

    public static void displayAllAppointments() {
        System.out.println("\nDisplaying all appointments...");
        List<Appointment> appointments = Appointment.readFromFile("Appointments.txt");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.toString());
        }
    }

    // Method to read list of appointments from a file
public static List<Appointment> readFromFile(String filename) {
    List<Appointment> appointments = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String patientName = parts[0];
                String doctorName = parts[1];
                LocalDate appointmentDate = LocalDate.parse(parts[2]);
                LocalTime appointmentTime = LocalTime.parse(parts[3]);
                Appointment appointment = new Appointment(patientName, doctorName, appointmentDate, appointmentTime);
                appointments.add(appointment);
            }
        }
    } catch (IOException | DateTimeParseException e) {
        System.out.println("Error reading appointment information from file: " + e.getMessage());
    }
    return appointments;
}

public static List<Appointment> getAppointmentsByPatientName(String patientName) {
    List<Appointment> appointments = readFromFile("Appointments.txt");
    List<Appointment> appointmentsByPatient = new ArrayList<>();

    for (Appointment appointment : appointments) {
        if (appointment.getPatientName().equalsIgnoreCase(patientName)) {
            appointmentsByPatient.add(appointment);
        }
    }

    return appointmentsByPatient;
}

public static List<Appointment> getAppointmentsByDoctorName(String patientName) {
    List<Appointment> appointments = readFromFile("Appointments.txt");
    List<Appointment> appointmentsByDoctor = new ArrayList<>();

    for (Appointment appointment : appointments) {
        if (appointment.getDoctorName().equalsIgnoreCase(doctorName)) {
            appointmentsByDoctor.add(appointment);
        }
    }

    return appointmentsByDoctor;
}

    // Getter for patientName
    public String getPatientName() {
        return patientName;
    }

    // Getter for patientName
    public String getDoctorName() {
        return doctorName;
    }

}
