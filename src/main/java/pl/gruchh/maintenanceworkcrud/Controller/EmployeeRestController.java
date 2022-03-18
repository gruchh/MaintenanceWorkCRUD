package pl.gruchh.maintenanceworkcrud.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeRestController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/v1/employees")
    public List<EmployeeDto> getAllEmployeesList() {
        List<Employee> employees = employeeService.getEmployeeList();
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private EmployeeDto convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
