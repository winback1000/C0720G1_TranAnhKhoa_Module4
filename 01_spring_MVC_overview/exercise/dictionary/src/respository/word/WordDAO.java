package respository.word;

import respository.DAO;
import respository.IWordDAO;
import model.Word;

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
