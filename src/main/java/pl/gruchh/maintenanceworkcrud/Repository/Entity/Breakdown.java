package pl.gruchh.maintenanceworkcrud.Repository.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Breakdowns")
public class Breakdown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate breakdownStartDate;
    private Long durationTime;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getBreakdownStartDate() {
        return breakdownStartDate;
    }

    public void setBreakdownStartDate(LocalDate breakdownStartDate) {
        this.breakdownStartDate = breakdownStartDate;
    }

    public Long getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Long durationTime) {
        this.durationTime = durationTime;
    }
}
