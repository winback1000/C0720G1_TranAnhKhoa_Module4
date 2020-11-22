package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.WordMeaningService;

@Controller
public class mainController {
    @Autowired
    WordMeaningService wordMeaningService;

    @GetMapping("/home")
    String homepage(Model model) {
        model.addAttribute("wordList", wordMeaningService.getAllWord());
//        model.addAttribute("addingStatus",false);
        return "home";
    }
    @GetMapping("/home/search")
    String lookUpWord(@RequestParam String searchData, Model model) {
        model.addAttribute("wordList", wordMeaningService.lookUp(searchData));
//        model.addAttribute("addingStatus",true);
        return "home";
    }
}
