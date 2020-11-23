package service;

import respository.wordMeaning.WordMeaningDAO;
import model.WordMeaning;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordMeaningService {

    public List<WordMeaning> getAllWord() {
        return new WordMeaningDAO().getAllWordMeaning();
    }
    public List<WordMeaning> lookUp(String word) {
        return new WordMeaningDAO().lookUpWord(word);
    }
    public boolean addWord (String word, String meaning) {
        return new WordMeaningDAO().addWord(new WordMeaning(word, meaning));
    }
}
