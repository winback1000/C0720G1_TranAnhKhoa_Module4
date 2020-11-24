package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ICalculator;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculator iCalculator;

    @RequestMapping({"","/","home"})
    public String showPage () {
        return "index";
    }
    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String calculate(@RequestParam double firstParameter, @RequestParam double secondParameter, @RequestParam String action, Model model) {
       model.addAttribute("result", iCalculator.calculate(action, firstParameter,secondParameter));
        return "index";
    }
}
