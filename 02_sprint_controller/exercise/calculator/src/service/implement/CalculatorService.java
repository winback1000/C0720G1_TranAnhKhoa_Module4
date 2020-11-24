package service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ICalculator;

@Service
public class CalculatorService implements ICalculator {


    @Override
    public double plus(double a, double b) {
        return a+b;
    }

    @Override
    public double minus(double a, double b) {
        return a-b;
    }

    @Override
    public double multiple(double a, double b) {
        return a*b;
    }

    @Override
    public double divine(double a, double b) {
        return a/b;
    }
}
