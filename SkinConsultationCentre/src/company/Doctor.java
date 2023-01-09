package company;

import java.time.LocalDateTime;

// Person's child class
public class Doctor extends Person {
    private String licenceNumber;
    private String specialisation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    //Constructor
    public Doctor(String licenceNumber, String name, String surname,String specialisation,String dateOfBirth, String mobileNumber,  LocalDateTime startTime, LocalDateTime endTime) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
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
