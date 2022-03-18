package pl.gruchh.maintenanceworkcrud.Service;

import org.springframework.stereotype.Service;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<WorksDto> getAllWorksSummary();
    List<Employee> getEmployeeList();

}
