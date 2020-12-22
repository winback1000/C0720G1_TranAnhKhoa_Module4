package com.codegym.controller;

import com.codegym.entity.Purchasing;
import com.codegym.service.ICustomerService;
import com.codegym.service.IPurchasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping({"","/"})
public class MainController {

    @Autowired
    private IPurchasingService iPurchasingService;

    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public String goHome(Model model ){
        model.addAttribute("purchasingList", iPurchasingService.findAll());
        return "homePage";
    }

    @GetMapping("/add")
    public String goAddPage(Model model){
        model.addAttribute("purchasing", new Purchasing());
        model.addAttribute("customerList", iCustomerService.findAll());
        return "addPurchasingPage";
    }

    @PostMapping("/purchase/save")
    public String saveEmployee(@Valid @ModelAttribute Purchasing purchasing, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("customerList", iCustomerService.findAll());
            return "addPurchasingPage";
        } else {
            iPurchasingService.save(purchasing);
            redirectAttributes.addFlashAttribute("message", "Add Purchasing Successful");
            return "redirect:/";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam String serviceType, @RequestParam String keyword, Model model) {
        model.addAttribute("purchasingList", iPurchasingService.search(serviceType,keyword));
        return "homePage";
    }

    @GetMapping("/delete")
    public String search(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iPurchasingService.deleteById(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Successful");
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        model.addAttribute("purchasing",  iPurchasingService.selectPurchasingById(id));
        return "purchasingDetail";

    }

}
