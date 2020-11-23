package respository;

import model.Meaning;

import java.util.List;

public interface IMeaningDAO{
    List<Meaning> getAllMeaning();
    List<Meaning> lookUpMeaning(String meaning);
    boolean addMeaning(String meaning);
    boolean updateMeaning(int id, String meaning);
    boolean deleteMeaning(int id);
}
