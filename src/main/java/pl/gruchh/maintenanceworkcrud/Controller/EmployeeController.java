package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.WorksDto;
import pl.gruchh.maintenanceworkcrud.Service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getAllDurationTime(Model model) {
        List<WorksDto> allWorksSummary = employeeService.getAllWorksSummary();
        model.addAttribute("allWorksSummary", allWorksSummary);
        return "index";
    }


}
