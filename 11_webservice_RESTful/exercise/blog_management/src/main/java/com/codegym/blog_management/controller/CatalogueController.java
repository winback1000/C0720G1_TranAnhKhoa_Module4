package com.codegym.blog_management.controller;

import com.codegym.blog_management.entity.Catalogue;
import com.codegym.blog_management.service.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    private ICatalogueService iCatalogueService;

    @GetMapping("/view/{id}")
    public String goCataloguePage (Model model, @PathVariable int id, Pageable pageable) {
        int catalogueSelected = id;
        model.addAttribute("catalogueId", catalogueSelected);
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        model.addAttribute("catalogueBlogList", iCatalogueService.getAllBlogOfCatalogue(id,pageable));
        return "catalogueHome";
    }
    @GetMapping("/manage")
    public String catalogueManagement (Model model, Pageable pageable) {
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        model.addAttribute("catalogueNameList", iCatalogueService.getCatalogueByPage(pageable));
        return "catalogueManager";
    }
    @GetMapping("/delete")
    public String deleteCatalogue(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        iCatalogueService.deleteCatalogue(deleteId);
        redirectAttributes.addFlashAttribute("message","Delete Successful");
        return "redirect:/catalogue/manage";
    }
    @GetMapping("/add")
    public String createCataloguePage (Model model){
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        model.addAttribute("catalogue", new Catalogue());
        return "catalogueCreate";
    }
    @PostMapping("/save")
    public String saveCatalogue (@ModelAttribute Catalogue catalogue, RedirectAttributes redirectAttributes){
        iCatalogueService.saveCatalogue(catalogue);
        redirectAttributes.addFlashAttribute("message", "Save catalogue successful");
        return "redirect:/catalogue/manage";
    }
    @GetMapping("/edit/{id}" )
    public String editCataloguePage (Model model, @PathVariable int id){
        model.addAttribute("catalogueList", iCatalogueService.getAllCatalogue());
        model.addAttribute("catalogue", iCatalogueService.selectCatalogueById(id));
        return "catalogueCreate";
    }
}
