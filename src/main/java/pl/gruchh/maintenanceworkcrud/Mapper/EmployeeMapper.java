package pl.gruchh.maintenanceworkcrud.Mapper;

import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

public interface EmployeeMapper {

    EmployeeDto convertEmployeeToDto(Employee employee);
    Employee convertDtoToEmployee(EmployeeDto employeeDto);

}
