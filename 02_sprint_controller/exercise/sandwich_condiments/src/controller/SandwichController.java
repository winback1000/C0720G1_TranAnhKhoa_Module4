package controller;

import model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ISandwich;

import java.util.ArrayList;

@Controller
public class SandwichController {

    @Autowired
    private ISandwich iSandwich;

    @RequestMapping("/save")
    public String save (@RequestParam String name,@RequestParam("condiments") String[] condiments, Model model) {
        iSandwich.addNewSandwich(new Sandwich(name, condiments));
        model.addAttribute("sandwichList", iSandwich.getAll());
        return "list";
    }
    @RequestMapping("/add")
    public String addNewSandwich() {

        return "add";
    }
    @RequestMapping({"","/list"})
    public String showList(Model model){
        model.addAttribute("sandwichList", iSandwich.getAll());
        return "list";
    }
}
