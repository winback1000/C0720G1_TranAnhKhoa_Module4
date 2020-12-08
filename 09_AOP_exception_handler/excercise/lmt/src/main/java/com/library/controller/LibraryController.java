package com.library.controller;

import com.library.model.Book;
import com.library.model.BorrowCard;
import com.library.model.TempBorrowCard;
import com.library.service.IBookService;
import com.library.service.IBorrowCardService;
import com.library.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"bookList", "studentList"})

public class LibraryController {

    @Autowired
    private IBookService iBookService;
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IBorrowCardService iBorrowCardService;

    @GetMapping({"","/"})
    public String goHome(Model model) {
        List<Book> borrowList = new ArrayList<>();
        model.addAttribute("bookList", iBookService.getAll());
        model.addAttribute("tempBorrowCard", new TempBorrowCard());
        model.addAttribute("studentList", iStudentService.getAll());
        return "homePage";
    }

    @PostMapping("/confirm")
    public String addBookToCard(Model model, @Valid @ModelAttribute TempBorrowCard tempBorrowCard, BindingResult bindingResult, @RequestParam String idList, RedirectAttributes redirectAttributes) {
       if ((bindingResult.hasErrors())) {
           return "homePage";
       } else {
           String[] arr = idList.split(" ");
           iBorrowCardService.save(tempBorrowCard, arr);
           redirectAttributes.addFlashAttribute("message", "Lending Book(s) Successful");
           return "redirect:/";
       }
    }
}
