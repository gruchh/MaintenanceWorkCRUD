package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("allWorksSummary", allWorksSummary);
        return "index";
    }

    @GetMapping("/addNewEmployee")
    public String getNewEmployeeForm(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("Employee", employeeDto);
        return "forms/AddForm";
    }

    @PostMapping("/addNewEmployee")
    public String saveEmployee(@Valid EmployeeDto employeeDto) throws EmployeeAlreadyExistsException {
        EmployeeDto newEmployee = employeeService.saveNewEmployee(employeeDto);
        return "redirect:/";
    }

    @GetMapping("/showAllEmployees")
    public String getRemoveEmployeeForm(Model model) {
        List<EmployeeDto> allEmployees = employeeService.getEmployeeList();
        model.addAttribute("allEmployees", allEmployees);

        return "forms/AllEmployees";
    }

    @GetMapping("/updateEmployee")
    public String getUpdateEmployeeForm() {
        return "forms/ajax/UpdateForm";
    }

}
