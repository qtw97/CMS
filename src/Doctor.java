import java.io.*;
import java.util.*;

public class Doctor extends Person {
    private String employedDate;
    private String specialty;

    public Doctor(String firstName, String lastName, String birthdate, String employedDate, String specialty) {
        super(firstName, lastName, birthdate);
        this.employedDate = employedDate;
        this.specialty = specialty;
    }

    public String getEmployedDate() {
        return employedDate;
    }

    public void setEmployedDate(String employedDate) {
        this.employedDate = employedDate;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + getFullName() + '\'' +
                ", birthdate='" + getDateOfBirth() + '\'' +
                ", employedDate='" + employedDate + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

    // Method to save doctor information to a file
    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Doctors.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
    
            // Write doctor details to the file
            printWriter.println(getFullName() + "," + getDateOfBirth() + "," + employedDate + "," + specialty);
    
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving doctor information: " + e.getMessage());
        }
    }
    
    public static void registerNewDoctor(Scanner scanner) {
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

    
    public static void displayAllDoctors() {
        System.out.println("\nDisplaying all doctors...");
        List<Doctor> doctors = Doctor.readFromFile("Doctors.txt");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }

    // Method to read list of doctors from a file
    public static List<Doctor> readFromFile(String filename) {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String[] nameParts = parts[0].split(" ");
                    String firstName = nameParts[0];
                    String lastName = nameParts[1];
                    String birthdate = parts[1];
                    String employedDate = parts[2];
                    String specialty = parts[3];
                    Doctor doctor = new Doctor(firstName, lastName, birthdate, employedDate, specialty);
                    doctors.add(doctor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading doctor information from file: " + e.getMessage());
        }
        return doctors;
    }

     // Method to modify an existing doctor
     public static void modifyDoctor(String doctorFullName, String employedDate, String specialty) {
        List<Doctor> allDoctors = readFromFile("Doctors.txt");
        for (Doctor doctor : allDoctors) {
            if (doctor.getFullName().equalsIgnoreCase(doctorFullName)) {
                doctor.setEmployedDate(employedDate);
                doctor.setSpecialty(specialty);
                updateDoctorsInFile(allDoctors);
                System.out.println("Doctor information updated successfully.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    // Method to delete an existing doctor
    public static void deleteDoctor(String doctorFullName) {
        List<Doctor> allDoctors = readFromFile("Doctors.txt");
        Iterator<Doctor> iterator = allDoctors.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            if (doctor.getFullName().equalsIgnoreCase(doctorFullName)) {
                iterator.remove();
                updateDoctorsInFile(allDoctors);
                System.out.println("Doctor deleted successfully.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    // Method to update doctor information in file
    private static void updateDoctorsInFile(List<Doctor> doctors) {
        try {
            FileWriter fileWriter = new FileWriter("Doctors.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Doctor doctor : doctors) {
                printWriter.println(doctor.getFullName() + "," + doctor.getDateOfBirth() + "," +
                        doctor.getEmployedDate() + "," + doctor.getSpecialty());
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error updating doctor information: " + e.getMessage());
        }
    }

}