import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    

    public Person(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    //set the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //set the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    //set the date of birth
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Parse the date of birth string to a LocalDate object
        LocalDate birthDate = LocalDate.parse(dateOfBirth);

        // Calculate the difference in years
        return Period.between(birthDate, currentDate).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getFullName() + '\'' +
                ", birthdate='" + dateOfBirth + '\'' +
                '}';
    }
}