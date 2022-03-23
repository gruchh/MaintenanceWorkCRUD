package pl.gruchh.maintenanceworkcrud.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeRestController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployeesList() {
        List<Employee> employees = employeeService.getEmployeeList();
        return employees.stream()
                .map(this::convertEmployeeToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/employee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDto employeeDto) throws EmployeeAlreadyExistsException {
        Employee employee = convertDtoToEmployee(employeeDto);
        Employee newEmployee = employeeService.saveNewEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> EmployeeAlreadyExistsException() {
        return new ResponseEntity<>("Employee already exists", HttpStatus.CONFLICT);
    }

    private EmployeeDto convertEmployeeToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    private Employee convertDtoToEmployee (EmployeeDto employeeDto) {return modelMapper.map(employeeDto, Employee.class);}
}
