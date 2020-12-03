package com.codegym.controller;

import com.codegym.model.BorrowCard;
import com.codegym.service.IBookService;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LibraryController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IStudentService iStudentService;

    @GetMapping({"","/"})
    public String goHome(Model model){
        model.addAttribute("bookList", iBookService.getAll());
        model.addAttribute("borrowCard", new BorrowCard());
        model.addAttribute("studentList", iStudentService.getAll());
        return "homePage";
    }
}
