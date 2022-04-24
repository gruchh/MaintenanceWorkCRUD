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

    boolean existsEmployeeByNameAndSurname(String name, String Surname);
}
