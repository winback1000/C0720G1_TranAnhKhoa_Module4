package com.furama.controller;

import com.furama.entity.Employee;
import com.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IAccountService iAccountService;
    @GetMapping("")
    public String goEmployeePage(Model model, Pageable pageable, @RequestParam Optional<String> keyword) {
        String searchData="";
        if(!keyword.isPresent()) {
            model.addAttribute("employeePageList", iEmployeeService.findAllWithPage(pageable));
        } else {
            searchData = keyword.get();
            model.addAttribute("employeePageList", iEmployeeService.searchEmployee(searchData, pageable));
            model.addAttribute("searchData", searchData);
        }
        return "employee";
    }
    @GetMapping("/view/{id}")
    public String goEmployeeDetailPage(Model model, @PathVariable int id) {
        model.addAttribute("employee", iEmployeeService.selectEmployeeById(id));
        return "employeeDetail";
    }

    @GetMapping("/edit/{id}")
    public String goEditEmployeeDPage(Model model, @PathVariable int id) {
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("accountList", iAccountService.findAll());
        model.addAttribute("employee", iEmployeeService.selectEmployeeById(id));
        return "editEmployee";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        for (Employee emp: iEmployeeService.findAll()) {
            if(emp.getIdCard().equals(employee.getIdCard()) && !emp.getId().equals(employee.getId())) {
                bindingResult.rejectValue("idCard", "error.employee", "The ID card is already exist");
                break;
            }
        }

        for (Employee emp: iEmployeeService.findAll()) {
            if(emp.getEmail().equals(employee.getEmail()) && !emp.getId().equals(employee.getId())) {
                bindingResult.rejectValue("email", "error.employee", "The email is already used");
                break;
            }
        }

        if(bindingResult.hasErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationList", iEducationDegreeService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());
            model.addAttribute("accountList", iAccountService.findAll());
            return "editEmployee";
        } else {
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("successMessage", "Save Employee Successful");
            return "redirect:/employees";
        }
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("accountList", iAccountService.findAll());
        return "editEmployee";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int deleteID, RedirectAttributes redirectAttributes){
        iEmployeeService.delete(deleteID);
        redirectAttributes.addFlashAttribute("successMessage", "Delete Successful");
        return "redirect:/employees";
    }
}
