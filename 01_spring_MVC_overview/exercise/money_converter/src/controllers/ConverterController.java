package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IConverter;

@Controller
public class ConverterController {

    @Autowired
    private IConverter usdToVnd;
    @GetMapping({"","/converter"})
    public String convert(@RequestParam String amount, @RequestParam String unit, Model model) {
        model.addAttribute("amount", amount );
        if (unit.equals("USD")){
            model.addAttribute("result", usdToVnd.convert(Double.parseDouble(amount)));
        } else {
            model.addAttribute("result", null);
        }
        return "home";
    }
}
