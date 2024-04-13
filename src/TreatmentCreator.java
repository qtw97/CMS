public class TreatmentCreator {

    // Method to create a new treatment
    public static void createTreatment(String doctorName, String patientName, String medication, String description) {
        System.out.println("Creating treatment for " + patientName + " by Dr. " + doctorName);

        // Additional logic to process and save the treatment details, e.g., writing to a file
        saveTreatmentToFile(doctorName, patientName, medication, description);
    }

    // Example method to save treatment details to a file
    private static void saveTreatmentToFile(String doctorName, String patientName, String medication, String description) {
        // Implement file writing logic here
        // For demonstration, print the treatment details to console
        System.out.println("Treatment details saved:");
        System.out.println("Doctor: " + doctorName);
        System.out.println("Patient: " + patientName);
        System.out.println("Medication: " + medication);
        System.out.println("Description: " + description);
    }
}
