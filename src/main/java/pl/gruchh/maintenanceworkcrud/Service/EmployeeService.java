package pl.gruchh.maintenanceworkcrud.Service;

import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<WorksDto> getAllWorksSummary();
    List<EmployeeDto> getEmployeeList();
    EmployeeDto saveNewEmployee(EmployeeDto newEmployee) throws EmployeeAlreadyExistsException;
    EmployeeDto getEmployeeById(Long id) throws EmployeeNotFoundException;
    EmployeeDto editEmployee (Long id, EmployeeDto editedEmployeeDto);
}
