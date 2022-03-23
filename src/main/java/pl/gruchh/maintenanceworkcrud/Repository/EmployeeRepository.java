package pl.gruchh.maintenanceworkcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select new pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto(employee.name, sum(breakdown.durationTime + workOrder.durationTime))" +
            "from Employee employee " +
            "join employee.workOrder workOrder " +
            "join employee.breakdownSet breakdown group by employee.name")
    List<WorksDto> getWorkOrderAndBreakdownDurationTime();

    @Query(value = "select employee from Employee employee WHERE employee.name = ?1 and employee.surname = ?2")
    List<Employee> findEmployeeByNameAndSurname(String name, String surname);

    boolean existsEmployeeByNameAndSurname(String name, String Surname);

}
