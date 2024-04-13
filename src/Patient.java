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

    //setter methods
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
}
