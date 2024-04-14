import java.io.*;
import java.util.*;

public class Patient extends Person {
    private String work;
    private String insurance;

    public Patient(String firstName, String lastName, String birthdate, String work, String insurance) {
        super(firstName, lastName, birthdate);
        this.work = work;
        this.insurance = insurance;
    }

    public String getEmployer() {
        return work;
    }

    public String getInsuranceCompany() {
        return insurance;
    }

    // Setter methods
    public void setEmployer(String work) {
        this.work = work;
    }

    public void setInsuranceCompany(String insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + getFullName() + '\'' +
                ", birthdate='" + getDateOfBirth() + '\'' +
                ", employer='" + work + '\'' +
                ", insuranceCompany='" + insurance + '\'' +
                '}';
    }

    // Method to save patient information to a text file
    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Patients.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write patient details to the file
            printWriter.println(getFullName() + "," + getDateOfBirth() + "," + work + "," + insurance);

            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving patient information: " + e.getMessage());
        }
    }

    
    public static void registerNewPatient(Scanner scanner) {
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

    public static void displayAllPatients() {
        System.out.println("\nDisplaying all patients...");
        List<Patient> patients = Patient.readFromFile("Patients.txt");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }

    // Method to read list of patients from a file
    public static List<Patient> readFromFile(String filename) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String[] nameParts = parts[0].split(" ");
                    String firstName = nameParts[0];
                    String lastName = nameParts[1];
                    String birthdate = parts[1];
                    String work = parts[2];
                    String insurance = parts[3];
                    Patient patient = new Patient(firstName, lastName, birthdate, work, insurance);
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading patient information from file: " + e.getMessage());
        }
        return patients;
    }

        // Method to modify an existing patient
        public static void modifyPatient(String patientFullName, String attributeToModify, String newValue) {
            List<Patient> allPatients = readFromFile("Patients.txt");
            for (Patient patient : allPatients) {
                if (patient.getFullName().equalsIgnoreCase(patientFullName)) {
                    if (attributeToModify.equalsIgnoreCase("birthdate")) {
                        patient.setDateOfBirth(newValue);
                    } else if (attributeToModify.equalsIgnoreCase("work")) {
                        patient.setEmployer(newValue);
                    } else if (attributeToModify.equalsIgnoreCase("insurance")) {
                        patient.setInsuranceCompany(newValue);
                    }
                    updatePatientsInFile(allPatients);
                    System.out.println("Patient information updated successfully.");
                    return;
                }
            }
            System.out.println("Patient not found.");
        }
    
        // Method to delete an existing patient
        public static void deletePatient(String patientFullName) {
            List<Patient> allPatients = readFromFile("Patients.txt");
            Iterator<Patient> iterator = allPatients.iterator();
            while (iterator.hasNext()) {
                Patient patient = iterator.next();
                if (patient.getFullName().equalsIgnoreCase(patientFullName)) {
                    iterator.remove();
                    updatePatientsInFile(allPatients);
                    System.out.println("Patient deleted successfully.");
                    return;
                }
            }
            System.out.println("Patient not found.");
        }
    
        // Method to update patient information in file
        private static void updatePatientsInFile(List<Patient> patients) {
            try {
                FileWriter fileWriter = new FileWriter("Patients.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (Patient patient : patients) {
                    printWriter.println(patient.getFullName() + "," + patient.getDateOfBirth() + "," +
                            patient.getEmployer() + "," + patient.getInsuranceCompany());
                }
                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error updating patient information: " + e.getMessage());
            }
        }
}