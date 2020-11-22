package DAO;

import model.Word;

import java.util.List;

public interface IWordDAO{
    List<Word> getAllWord();
    List<Word> lookUpWord(String word);
    boolean addWord(String word);
    boolean updateWord(int id, String word);
    boolean deleteWord(int id);
}
