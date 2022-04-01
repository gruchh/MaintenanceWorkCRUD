package pl.gruchh.maintenanceworkcrud.Service;

import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<WorksDto> getAllWorksSummary();
    List<Employee> getEmployeeList();
    Employee saveNewEmployee(Employee newEmployee) throws EmployeeAlreadyExistsException;
    Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

}
