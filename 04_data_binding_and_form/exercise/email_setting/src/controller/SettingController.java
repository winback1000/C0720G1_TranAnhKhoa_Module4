package controller;

import model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ISettingService;

@Controller
public class SettingController {

    @Autowired
    private ISettingService iSettingService;

    @RequestMapping({"","/","/home"})
    public String goHome(Model model) {
        model.addAttribute("setting" , new Setting());
        model.addAttribute("languageList" , iSettingService.getLanguageList());
        model.addAttribute("pageList", iSettingService.getPageList());
        return "index";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute Setting setting, Model model){
        model.addAttribute("setting", iSettingService.saveSetting(setting));
        model.addAttribute("message" ,"Save successful !!!");
        return "review";
    }
}
