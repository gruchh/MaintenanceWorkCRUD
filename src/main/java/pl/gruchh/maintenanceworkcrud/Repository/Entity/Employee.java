package pl.gruchh.maintenanceworkcrud.Repository.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate dateOfEmployment;
    private BigDecimal salary;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Phone phone;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Breakdown> breakdownSet;

    @OneToMany(mappedBy = "employee")
    private Set<WorkOrder> workOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Set<Breakdown> getBreakdownSet() {
        return breakdownSet;
    }

    public void setBreakdownSet(Set<Breakdown> breakdownSet) {
        this.breakdownSet = breakdownSet;
    }

    public Set<WorkOrder> getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(Set<WorkOrder> workOrder) {
        this.workOrder = workOrder;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", salary=" + salary +
                ", phone=" + phone.getNumber() +
                ", workOrderSet=" + breakdownSet.toString() +
                '}';
    }
}
