package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkcrud.Mapper.EmployeeMapper;
import pl.gruchh.maintenanceworkcrud.Mapper.EmployeeMapperImpl;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployeesList() {
        return employeeService.getEmployeeList();
    }

    @PostMapping("/addNewEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDto employeeDto) throws EmployeeAlreadyExistsException {
        EmployeeDto newEmployee = employeeService.saveNewEmployee(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> EmployeeAlreadyExistsException() {
        return new ResponseEntity<>("Employee already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<String> EmployeeNotFoundException() {
        return new ResponseEntity<>("Employee not found", HttpStatus.CONFLICT);
    }

}
