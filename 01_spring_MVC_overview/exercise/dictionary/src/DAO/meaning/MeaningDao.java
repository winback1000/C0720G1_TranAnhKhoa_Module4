package DAO.meaning;


import DAO.DAO;
import DAO.IMeaningDAO;
import model.Meaning;

import java.util.List;

public class MeaningDao extends DAO implements IMeaningDAO {
    @Override
    public List<Meaning> getAllMeaning() {
        return null;
    }

    @Override
    public List<Meaning> lookUpMeaning(String meaning) {
        return null;
    }

    @Override
    public boolean addMeaning(String meaning) {
        return false;
    }

    @Override
    public boolean updateMeaning(int id, String meaning) {
        return false;
    }

    @Override
    public boolean deleteMeaning(int id) {
        return false;
    }
}
