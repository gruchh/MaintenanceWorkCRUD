package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<EmployeeDto> getAllEmployeesList() {
        return employeeService.getEmployeeList();
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) throws EmployeeAlreadyExistsException {
        EmployeeDto newEmployee = employeeService.saveNewEmployee(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<EmployeeDto> editEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto newEmployee = employeeService.editEmployee(id, employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }


}
