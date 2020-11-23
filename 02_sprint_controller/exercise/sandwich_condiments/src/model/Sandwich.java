package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich {

    String name;
    String[] condiments;

    public Sandwich() {
    }

    public Sandwich(String name, String[] condiments) {
        this.name = name;
        this.condiments = condiments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondiments() {
        return Arrays.toString(this.condiments);
    }

    public void setCondiments(String[] condiments) {
        this.condiments = condiments;
    }
}
