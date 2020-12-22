package com.furama.controller;


import com.furama.entity.Employee;
import com.furama.entity.Service;
import com.furama.service.IRentTypeService;
import com.furama.service.IServiceService;
import com.furama.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private IServiceTypeService iServiceTypeService;
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String goServicePage(Model model, Pageable pageable, @RequestParam Optional<String> keyword){
        String searchData="";
        if(!keyword.isPresent()) {
            model.addAttribute("servicePage", iServiceService.findAllWithPage(pageable));
        } else {
            searchData = keyword.get();
            model.addAttribute("servicePage", iServiceService.searchService(searchData, pageable));
            model.addAttribute("searchData", searchData);
        }
        return "service";
    }
    @GetMapping("/edit/{id}")
    public String goEditEmployeeDPage(Model model, @PathVariable int id) {
        model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("service", iServiceService.selectServiceById(id));
        return "editService";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute Service service, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            System.out.println(bindingResult.getAllErrors());
            return "editService";
        } else {
            iServiceService.save(service);
            redirectAttributes.addFlashAttribute("successMessage", "Save Service Successful");
            System.out.println("OK");
            return "redirect:/services";
        }
    }
    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("service", new Service());
        return "editService";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int deleteID, RedirectAttributes redirectAttributes){
        iServiceService.delete(deleteID);
        redirectAttributes.addFlashAttribute("successMessage", "Delete Successful");
        return "redirect:/services";
    }
    @GetMapping("/view/{id}")
    public String goEmployeeDetailPage(Model model, @PathVariable int id) {
        model.addAttribute("service", iServiceService.selectServiceById(id));
        return "serviceDetail";
    }

}
