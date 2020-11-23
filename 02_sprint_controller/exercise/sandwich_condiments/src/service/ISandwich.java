package service;

import model.Sandwich;

import java.util.List;

public interface ISandwich {
    List<Sandwich> getAll();
    boolean addNewSandwich(Sandwich sandwich);
}
