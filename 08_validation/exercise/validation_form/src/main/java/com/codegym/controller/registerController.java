package com.codegym.controller;

import com.codegym.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class registerController {

    @GetMapping({"","/register"})
    public String goRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "registerPage";
    }
    @PostMapping("/save")
    public String saveUser(Model model, @Valid @ModelAttribute User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "registerPage";
        }
        else {
            return "index";
        }
    }
}
