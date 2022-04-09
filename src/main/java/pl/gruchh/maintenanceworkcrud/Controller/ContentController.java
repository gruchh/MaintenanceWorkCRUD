package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms")
public class ContentController {

    @RequestMapping("/")
    public String getFormsWebsite () {
        return "/forms/Forms";
    }

    @RequestMapping("/AddEmployee")
    public String getContent1() {
        return "/forms/ajax/AddForm";
    }

    @RequestMapping("/RemoveEmployee")
    public String getContent2() {
        return "forms//ajax/RemoveForm";
    }

}
