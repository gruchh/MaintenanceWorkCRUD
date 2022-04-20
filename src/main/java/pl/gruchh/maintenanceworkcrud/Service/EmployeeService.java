package pl.gruchh.maintenanceworkcrud.Service;

import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<WorksDto> getAllWorksSummary();
    List<EmployeeDto> getEmployeeList();
    EmployeeDto saveNewEmployee(EmployeeDto newEmployee) throws EmployeeAlreadyExistsException;
    EmployeeDto getEmployeeById(Long id) throws EmployeeNotFoundException;
    void deleteEmployeeById(Long id) throws EmployeeNotFoundException;

}
