package service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ICalculator;

@Service
public class CalculatorService implements ICalculator {


    @Override
    public String calculate(String action, double a, double b) {
        String result ="";
        double temResult;
        if(b == 0 && action.equals("divine")) {
            return "The divine action can't be used with the second parameter = 0";
        } else {
            switch (action) {
                case"plus":
                    temResult = a+b;
                    break;
                case "minus":
                    temResult = a-b;
                    break;
                case "multiple":
                    temResult = a*b;
                    break;
                case "divine":
                    temResult = a/b;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }
            result = result+temResult;
        }
        return result;
    }
}
