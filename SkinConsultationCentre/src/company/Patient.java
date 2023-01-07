package company;


import java.time.LocalDateTime;

public class Patient extends Person {
    private String personId;
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;


    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, String personId) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}