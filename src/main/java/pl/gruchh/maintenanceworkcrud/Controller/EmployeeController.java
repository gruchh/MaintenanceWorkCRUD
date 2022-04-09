package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Mapper.EmployeeMapper;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/")
    public String getAllDurationTime(Model model) {
        List<WorksDto> allWorksSummary = employeeService.getAllWorksSummary();
        List<EmployeeDto> allEmployees = employeeService.getEmployeeList();
        model.addAttribute("allWorksSummary", allWorksSummary);
        model.addAttribute("allEmployees", allEmployees);
        return "index";
    }

    @PostMapping("/addNewEmployee")
    public String saveEmployee(@Valid EmployeeDto employeeDto) throws EmployeeAlreadyExistsException {
        EmployeeDto newEmployee = employeeService.saveNewEmployee(employeeDto);

        return "redirect:/";
    }
}
