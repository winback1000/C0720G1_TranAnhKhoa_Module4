package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.IUserService;
import com.codegym.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class registerController {

    @Autowired
    private IUserService iUserService;

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
            iUserService.save(user);
            return "redirect:/home";
        }
    }
    @GetMapping("/home")
    public String userHome(Model model, Pageable pageable) throws Exception {

            model.addAttribute("userList", iUserService.findAll(pageable));
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String catchException () {
        return "errorPage";
    }
}
