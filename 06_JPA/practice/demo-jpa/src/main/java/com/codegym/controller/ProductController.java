package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping({"","/","/home"})
    public String goHome(){
        return "home";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("message","Save successful");
        return "redirect:/home";
    }
}
