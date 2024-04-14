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
    // Getter and setter for doctorName
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getter and setter for patientName
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // Getter and setter for medication
    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    // Getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    
                // Placeholder logic for creating treatment
                System.out.println("Enter medication for treatment:");
                String medication = scanner.nextLine();
    
                System.out.println("Enter description for treatment:");
                String description = scanner.nextLine();
    
                // Simulate treatment creation using TreatmentCreator class
                Treatments treatment = new Treatments(selectedDoctor.getFullName(),
                        selectedPatient.getFullName(), medication, description);
                treatment.saveToFile();
                System.out.println("Treatment created successfully.");
          
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
               
                    String doctorName = parts[0];
                    String patientName = parts[1];
                    String medication = parts[2];
                    String description = parts[3];
                    Treatments treatment = new Treatments(doctorName, patientName, medication, description);
                    treatments.add(treatment);
                
            }
        } catch (IOException e) {
            System.out.println("Error reading treatment information from file: " + e.getMessage());
        }
        return treatments;
    }
    
    // Method to get treatments by patient name
    public static List<Treatments> getTreatmentsByPatientName(String patientName) {
        List<Treatments> treatments = readFromFile("Treatments.txt");
        List<Treatments> treatmentsByPatient = new ArrayList<>();

        for (Treatments treatment : treatments) {
            if (treatment.getPatientName().equalsIgnoreCase(patientName)) {
                treatmentsByPatient.add(treatment);
            }
        }

        return treatmentsByPatient;
    }
    
    // Method to get treatments by doctor name
    public static List<Treatments> getTreatmentsByDoctorName(String doctorName) {
        List<Treatments> treatments = readFromFile("Treatments.txt");
        List<Treatments> treatmentsByDoctor = new ArrayList<>();

        for (Treatments treatment : treatments) {
            if (treatment.getDoctorName().equalsIgnoreCase(doctorName)) {
                treatmentsByDoctor.add(treatment);
            }
        }

        return treatmentsByDoctor;
    }



    public static void modifyTreatment(String patientName, String attributeToModify, String newValue) {
        List<Treatments> allTreatments = readFromFile("Treatments.txt");
        for (Treatments treatment : allTreatments) {
            if (treatment.getPatientName().equalsIgnoreCase(patientName)) {
                switch (attributeToModify.toLowerCase()) {
                    case "medication":
                        treatment.setMedication(newValue);
                        break;
                    case "description":
                        treatment.setDescription(newValue);
                        break;
                    default:
                        System.out.println("Invalid attribute to modify.");
                        return;
                }
                updateTreatmentsInFile(allTreatments);
                System.out.println("Treatment information updated successfully.");
                return;
            }
        }
        System.out.println("Treatment not found.");
    }

    // Method to delete an existing treatment
    public static void deleteTreatment(String patientName) {
        List<Treatments> allTreatments = readFromFile("Treatments.txt");
        boolean removed = allTreatments.removeIf(treatment -> treatment.getPatientName().equalsIgnoreCase(patientName));
        if (removed) {
            updateTreatmentsInFile(allTreatments);
            System.out.println("Treatment deleted successfully.");
        } else {
            System.out.println("Treatment not found.");
        }
    }

    // Method to update treatment information in file
    private static void updateTreatmentsInFile(List<Treatments> treatments) {
        try {
            FileWriter fileWriter = new FileWriter("Treatments.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Treatments treatment : treatments) {
                printWriter.println(treatment.getDoctorName() + "," + treatment.getPatientName() + "," +
                        treatment.getMedication() + "," + treatment.getDescription());
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error updating treatment information: " + e.getMessage());
        }
    }
}
