package company;

import java.time.LocalDateTime;

public class Consultation {

    private LocalDateTime dateTime;
    private double cost;
    private String notes;
    private LocalDateTime year;
    private LocalDateTime month;
    private LocalDateTime day;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Consultation(LocalDateTime dateTime, double cost, String notes, LocalDateTime year, LocalDateTime month, LocalDateTime day, LocalDateTime startTime, LocalDateTime endTime) {
        this.dateTime = dateTime;
        this.cost = cost;
        this.notes = notes;
        this.year = year;
        this.month = month;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public LocalDateTime getMonth() {
        return month;
    }

    public void setMonth(LocalDateTime month) {
        this.month = month;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
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
