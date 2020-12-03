package com.library.controller;

import com.library.model.Book;
import com.library.model.BorrowCard;
import com.library.service.IBookService;
import com.library.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private IBookService iBookService;
    @Autowired
    private IStudentService iStudentService;

    @GetMapping({"","/"})
    public String goHome(Model model) {
        List<Book> borrowList = new ArrayList<>();
        model.addAttribute("bookList", iBookService.getAll());
        model.addAttribute("borrowCard", new BorrowCard());
        model.addAttribute("studentList", iStudentService.getAll());
        model.addAttribute("borrowList", borrowList);
        return "homePage";
    }

    @GetMapping("/borrow/{id}")
    public String addBookToCard(Model model, @PathVariable int id, @ModelAttribute List<Book> borrowList){
        borrowList.add(iBookService.selectBookById(id));
        model.addAttribute("bookList", iBookService.getAll());
        model.addAttribute("borrowCard", new BorrowCard());
        model.addAttribute("studentList", iStudentService.getAll());
        model.addAttribute("borrowList", borrowList);
        return "homePage";
    }
}
