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
        model.addAttribute("first", firstParameter);
        model.addAttribute("second", secondParameter);
        if(secondParameter == 0 && action.equals("divine")){
            model.addAttribute("result", "The 2nd parameter can not be 0 in divine action");
        } else {
            switch (action) {
                case ("plus"):
                    model.addAttribute("result", iCalculator.plus(firstParameter,secondParameter));
                    break;
                case ("minus"):
                    model.addAttribute("result", iCalculator.minus(firstParameter,secondParameter));
                    break;
                case ("multiple"):
                    model.addAttribute("result", iCalculator.multiple(firstParameter,secondParameter));
                    break;
                case ("divine"):
                    model.addAttribute("result", iCalculator.divine(firstParameter,secondParameter));
                    break;
            }
        }
        return "index";
    }
}
