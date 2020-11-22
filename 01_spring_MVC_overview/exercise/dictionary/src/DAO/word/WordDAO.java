package DAO.word;

import DAO.DAO;
import DAO.IWordDAO;
import model.Word;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDAO extends DAO implements IWordDAO {

    @Override
    public List<Word> getAllWord() {
        return null;
    }

    @Override
    public List<Word> lookUpWord(String word) {
        return null;
    }

    @Override
    public boolean addWord(String word) {
        return false;
    }

    @Override
    public boolean updateWord(int id, String word) {
        return false;
    }

    @Override
    public boolean deleteWord(int id) {
        return false;
    }
}
