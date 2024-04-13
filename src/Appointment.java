import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private String patientName;
    private String doctorName;
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

}
