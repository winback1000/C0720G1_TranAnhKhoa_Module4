package com.furama.controller;

import com.furama.entity.Customer;
import com.furama.entity.Employee;
import com.furama.repository.CustomerDao;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import com.furama.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private IGenderService iGenderService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public String goEmployeePage(Model model, Pageable pageable, @RequestParam Optional<String> keyword, @RequestParam Optional<String> searchField) {
        String searchData="";
        String field="";
        if(!keyword.isPresent() || keyword.get().equals("")) {
            model.addAttribute("customerPage", iCustomerService.findAllWithPage(pageable));
        } else {
            searchData = keyword.get();
            field = searchField.get();
            String query = "select customer.* from customer join customer_type on customer.customer_type_id = customer_type.id join gender on customer.gender_id = gender.id where "+field+" like '%"+searchData+"%'";
            List customers = customerDao.dynamicQuery(query);
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), customers.size());
            Page<Customer> customerPage = new PageImpl<>(customers.subList(start, end), pageable, customers.size());
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("searchData", searchData);
            model.addAttribute("field", field);

//            model.addAttribute("customerPage", iCustomerService.searchCustomer(searchData, pageable));
//            model.addAttribute("searchData", searchData);
        }

        return "customer";
    }
    @GetMapping("/view/{id}")
    public String goEmployeeDetailPage(Model model, @PathVariable int id) {
        model.addAttribute("customer", iCustomerService.selectCustomerById(id));
        return "customerDetail";
    }

    @GetMapping("/edit/{id}")
    public String goEditEmployeeDPage(Model model, @PathVariable int id) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("genderList", iGenderService.findAll());
        model.addAttribute("customer", iCustomerService.selectCustomerById(id));
        return "editCustomer";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("genderList", iGenderService.findAll());
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "editCustomer";
        } else {
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Save Customer Successful");
            return "redirect:/customers";
        }
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("genderList", iGenderService.findAll());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "editCustomer";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int deleteID, RedirectAttributes redirectAttributes){
        iCustomerService.delete(deleteID);
        redirectAttributes.addFlashAttribute("successMessage", "Delete Successful");
        return "redirect:/customers";
    }
}
