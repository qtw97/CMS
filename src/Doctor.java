import java.io.FileWriter;
import java.io.IOException;

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

    // Method to save doctor information to a file
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("Doctors.txt", true);
            writer.write(toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving doctor information to file: " + e.getMessage());
        }
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
}
