package company;

import java.time.LocalDateTime;

public class Consultation {
    private double cost;
    private String notes;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Consultation(double cost, String notes, LocalDateTime startTime, LocalDateTime endTime) {
        this.cost = cost;
        this.notes = notes;
        this.startTime = startTime;
        this.endTime = endTime;
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
