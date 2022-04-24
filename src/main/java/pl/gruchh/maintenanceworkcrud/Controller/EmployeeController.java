package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Mapper.EmployeeMapper;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/work-summary")
    public String getAllDurationTime(Model model) {
        List<WorksDto> allWorksSummary = employeeService.getAllWorksSummary();
        model.addAttribute("allWorksSummary", allWorksSummary);
        return "index";
    }

    @GetMapping()
    public String getNewEmployeeForm(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("Employee", employeeDto);
        return "forms/AddForm";
    }

    @PostMapping()
    public String saveEmployee(@Valid EmployeeDto employeeDto) throws EmployeeAlreadyExistsException {
        EmployeeDto newEmployee = employeeService.saveNewEmployee(employeeDto);
        return "redirect:/";
    }

    @GetMapping("/all-employees")
    public String getAllEmployees(Model model) {
        List<EmployeeDto> allEmployees = employeeService.getEmployeeList();
        model.addAttribute("allEmployees", allEmployees);
        return "forms/AllEmployees";
    }

    @GetMapping("/{id}")
    public String getEmployeeForm(@PathVariable Long id, Model model) throws EmployeeAlreadyExistsException {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        model.addAttribute("Employee", employeeDto);
        return "forms/EditForm";
    }

    @PostMapping("/{id}")
    public String editEmployee(@PathVariable Long id, @Valid EmployeeDto employeeDto) {
        employeeService.editEmployee(id, employeeDto);
        return "redirect:/employees/all-employees";
    }

}
