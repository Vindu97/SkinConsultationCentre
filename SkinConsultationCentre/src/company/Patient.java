package company;


import java.time.LocalDateTime;

public class Patient extends Person {
    private int personId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, int personId, LocalDateTime startTime, LocalDateTime endTime) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.personId = personId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}