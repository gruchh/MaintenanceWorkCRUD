package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

@Controller
@RequestMapping("/forms")
public class ContentController {

    @RequestMapping("/")
    public String getFormsWebsite () {
        return "/forms/Forms";
    }

    @RequestMapping("/RemoveEmployee")
    public String getContent2() {
        return "forms//ajax/RemoveForm";
    }

}
