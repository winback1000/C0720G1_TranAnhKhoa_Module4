package respository.wordMeaning;

import respository.DAO;
import model.WordMeaning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordMeaningDAO extends DAO {
    public List<WordMeaning> getAllWordMeaning () {
        List<WordMeaning> wordMeaningList = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall("call list_all_word_meaning()")){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String word = rs.getString("word");
                String meaning = rs.getString("mean");
                wordMeaningList.add(new WordMeaning(word,meaning));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return wordMeaningList;
    }
    public List<WordMeaning> lookUpWord (String aWord) {
        List<WordMeaning> lookUpResult  = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall("call dictionary.look_up(?);")){
            callableStatement.setString(1,"%"+aWord+"%");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String word = rs.getString("word");
                String meaning = rs.getString("mean");
                lookUpResult.add(new WordMeaning(word,meaning));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lookUpResult;
    }
    public boolean addWord (WordMeaning wordMeaning) {
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall("call dictionary.add_word(?, ?);")){
            callableStatement.setString(1,wordMeaning.getWord());
            callableStatement.setString(2,wordMeaning.getMeaning());
            ResultSet rs = callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
        }
        public static void main(String[] args) {
        WordMeaningDAO wordMeaningDAO = new WordMeaningDAO();
        System.out.println(wordMeaningDAO.getAllWordMeaning());
        System.out.println(wordMeaningDAO.lookUpWord("rule"));
        System.out.println(wordMeaningDAO.addWord(new WordMeaning("mouse","con chuột")));
    }
}
