package service.iplm;

import model.Sandwich;
import org.springframework.stereotype.Service;
import service.ISandwich;

import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichImpl implements ISandwich {

    static List<Sandwich> sandwichList = new ArrayList<>();

    static {
        sandwichList.add(new Sandwich("Sandwich1", new String[] {"Lettuce", "Tomato", "Mustard", "Sprouts"}));
    }

    @Override
    public List<Sandwich> getAll() {
        return sandwichList;
    }

    @Override
    public boolean addNewSandwich(Sandwich sandwich) {
        try {
            sandwichList.add(sandwich);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
