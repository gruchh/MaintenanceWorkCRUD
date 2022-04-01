package pl.gruchh.maintenanceworkcrud.Repository.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WorkOrders")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private int orderWeight;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate deadLineDate;
    private Long durationTime;

    @ManyToOne
    @JoinColumn(name = "employee_FK")
    private Employee employee;

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(int orderWeight) {
        this.orderWeight = orderWeight;
    }

    public LocalDate getDeadLineDate() {
        return deadLineDate;
    }

    public Long getId() {
        return id;
    }

    public void setDeadLineDate(LocalDate deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public Long getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Long durationTime) {
        this.durationTime = durationTime;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", orderWeight=" + orderWeight +
                ", deadLineDate=" + deadLineDate +
                ", employeeName=" + employee.getName() +
                ", employeeSurname=" + employee.getSurname() +
                '}';
    }
}
