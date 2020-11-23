package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.WordMeaningService;

@Controller
@EnableWebMvc
public class mainController {
    @Autowired
    private WordMeaningService wordMeaningService;

    @RequestMapping ("/home")
    String homepage(Model model) {
        model.addAttribute("wordList", wordMeaningService.getAllWord());
//        model.addAttribute("addingStatus",false);
        return "home";
    }

    @RequestMapping(value = "/home/search", method = RequestMethod.POST)
    String lookUpWord(@RequestParam String searchData, Model model) {
        model.addAttribute("wordList", wordMeaningService.lookUp(searchData));
//        model.addAttribute("addingStatus",true);
        return "home";
    }
}
