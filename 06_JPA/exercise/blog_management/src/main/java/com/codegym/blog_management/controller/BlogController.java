package com.codegym.blog_management.controller;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;


@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"","/home"})
    public String goHome (Model model) {
        model.addAttribute("blogList", iBlogService.getAllBlog());
        return "home";
    }
    @GetMapping ("/blog/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping ("/blog/save-new-blog")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        LocalDate date = LocalDate.now();
        blog.setPostDate(date.toString());
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Save blog successful");
        return "redirect:/home";
    }

    @GetMapping("/blog/{id}/view")
    public String readBlock(@PathVariable int id, Model model) {
        model.addAttribute("blog",iBlogService.selectBlogById(id));
        return "view";
    }
    @GetMapping("/blog/edit/{id}")
    public String editBlog(@PathVariable int id, Model model){
        model.addAttribute("blog", iBlogService.selectBlogById(id));
        return "edit";
    }
    @PostMapping("/blog/save-blog")
    public String saveOldBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Save blog successful");
        return "redirect:/home";
    }

    @GetMapping("/blog/delete")
    public String deleteBlog(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iBlogService.deleteBlog(deleteId);
        redirectAttributes.addFlashAttribute("message" , "Delete Blog Successful!");
        return "redirect:/home";
    }
    @GetMapping("/search")
    public String searchBlog(@RequestParam String searchData, Model model) {
        model.addAttribute("blogList", iBlogService.searchBlog(searchData));
        return "home";
    }
}
