package service.implement;

import org.springframework.stereotype.Service;
import service.IConverter;

@Service
public class ConverterUSDToVND implements IConverter {
    @Override
    public double convert(double amount1) {
        return amount1*23000;
    }
}
