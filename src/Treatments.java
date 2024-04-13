import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Treatments {
    private String doctorName;
    private String patientName;
    private String medication;
    private String description;

    public Treatments(String doctorName, String patientName, String medication, String description) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.medication = medication;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", medication=" + medication +
                ", description=" + description +
                '}';
    }

    // Method to save treatment details to a file
    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Treatments.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
    
            // Write treatment details to the file
            printWriter.println(doctorName + "," + patientName + "," + medication + "," + description);
    
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving treatment information: " + e.getMessage());
        }
    }
    
    // Method to create a new treatment
    public static void createNewTreatment(Scanner scanner) {
        // Display list of patients to choose from
        System.out.println("\nDoctor Menu - Create New Treatment");
        System.out.println("Select a patient to create a treatment:");

        // Read patient list from file
        List<String> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                patients.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the patient file: " + e.getMessage());
            return;
        }

        // Display patient names for selection
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }

        // Get user input for patient selection
        System.out.print("Enter patient number: ");
        int patientIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (patientIndex >= 1 && patientIndex <= patients.size()) {
            String selectedPatient = patients.get(patientIndex - 1);
            System.out.println("Selected patient: " + selectedPatient);

            // Display list of doctors to choose from
            System.out.println("\nSelect a doctor for the treatment:");

            // Read doctor list from file
            List<String> doctors = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("Doctors.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    doctors.add(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the doctor file: " + e.getMessage());
                return;
            }

            // Display doctor names for selection
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println((i + 1) + ". " + doctors.get(i));
            }

            // Get user input for doctor selection
            System.out.print("Enter doctor number: ");
            int doctorIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (doctorIndex >= 1 && doctorIndex <= doctors.size()) {
                String selectedDoctor = doctors.get(doctorIndex - 1);
                System.out.println("Selected doctor: " + selectedDoctor);

                // Placeholder logic for creating treatment
                System.out.println("Enter medication for treatment:");
                String medication = scanner.nextLine();

                System.out.println("Enter description for treatment:");
                String description = scanner.nextLine();

                // Simulate treatment creation using TreatmentCreator class
                Treatments treatment = new Treatments(selectedDoctor, selectedPatient, medication, description);
                treatment.saveToFile();
                System.out.println("Treatment created successfully.");
            } else {
                System.out.println("Invalid doctor selection.");
            }
        } else {
            System.out.println("Invalid patient selection.");
        }
    }

    public static void displayAllTreatments() {
        System.out.println("\nDisplaying all treatments...");
        List<Treatments> treatments = Treatments.readFromFile("Treatments.txt");
        for (Treatments treatment : treatments) {
            System.out.println(treatment.toString());
        }
    }

    // Method to read list of treatments from a file
    public static List<Treatments> readFromFile(String filename) {
        List<Treatments> treatments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String doctorName = parts[0].substring(parts[0].indexOf(":") + 2).trim();
                    String patientName = parts[1].substring(parts[1].indexOf(":") + 2).trim();
                    String medication = parts[2].substring(parts[2].indexOf(":") + 2).trim();
                    String description = parts[3].substring(parts[3].indexOf(":") + 2).trim();
                    Treatments treatment = new Treatments(doctorName, patientName, medication, description);
                    treatments.add(treatment);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading treatment information from file: " + e.getMessage());
        }
        return treatments;
    }
}
