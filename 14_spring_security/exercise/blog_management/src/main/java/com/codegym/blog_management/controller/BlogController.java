package com.codegym.blog_management.controller;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.service.IBlogService;
import com.codegym.blog_management.service.ICatalogueService;
import com.codegym.blog_management.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;


@Controller
public class BlogController {
    private String searchAll;
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICatalogueService iCatalogueService;

    @GetMapping({"","/home","/blogList"})
    public String goHome (Model model, Pageable pageable) {
        searchAll="";
        model.addAttribute("blogList", iBlogService.getAllBlog(pageable));
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        return "home";
    }
    @GetMapping ("/blog/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
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
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
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
    public String searchBlog(@RequestParam String searchData, Model model, Pageable pageable) {
        searchAll = searchData;
        Page<Blog> blogList = iBlogService.searchBlog(searchAll, pageable);
        model.addAttribute("searchBlogList", blogList);
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        model.addAttribute("message", "There are "+blogList.getTotalElements()+" result(s) found");
        return "search";
    }

    @GetMapping("/searchBlogList")
    public String searchPage(Pageable pageable, Model model) {
        Page<Blog> blogList = iBlogService.searchBlog(searchAll, pageable);
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        model.addAttribute("searchBlogList", blogList);
        return "search";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
}
