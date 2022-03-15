package pl.gruchh.maintenanceworkcrud.Repository.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;

    @OneToOne(mappedBy = "phone")
    private Employee employee;

    public Long getNumber() {
        return number;
    }
    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
