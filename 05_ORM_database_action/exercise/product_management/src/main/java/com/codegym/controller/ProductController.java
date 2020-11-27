package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
    public String goHome(Model model){
        model.addAttribute("products",iProductService.getAllProduct());
        return "home";
    }
    @RequestMapping (value = "/product/create", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @RequestMapping (value = "/product/save", method = RequestMethod.POST)
    public String createProduct(RedirectAttributes redirectAttributes, @ModelAttribute Product product) {
        iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Create new product successfully!!!");
        return "redirect:/home";
    }
    @RequestMapping (value = "/product/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iProductService.deleteProduct(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete product successfully!!!");
        return "redirect:/home";
    }
    @RequestMapping (value = "/product/edit/{id}", method = RequestMethod.GET)
    public String editProduct (@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.selectProductById(id));
        return "edit";
    }
    @RequestMapping (value = "/product/update", method = RequestMethod.POST)
    public String updateProduct (@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.editProduct(product);
        redirectAttributes.addFlashAttribute("message", "Update product successfully!!!");
        return "redirect:/home";
    }

    @RequestMapping (value = "/search", method = RequestMethod.GET)
    public String searchProduct (@RequestParam String searchData,Model model) {
        model.addAttribute("products",iProductService.searchProduct(searchData));
        return "home";
    }
}
