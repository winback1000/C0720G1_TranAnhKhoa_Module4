package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IEmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping(value = {"","/","/employee"} , method = RequestMethod.GET)
    public String goHome(Model model) {
        model.addAttribute("employeeList" , iEmployeeService.getAllEmployee());
        return "index";
    }

    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String goCreate(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createEmployee(Model model, @ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.addEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Create new employee successful!!!");
        return "redirect:/employee";
    }
}
