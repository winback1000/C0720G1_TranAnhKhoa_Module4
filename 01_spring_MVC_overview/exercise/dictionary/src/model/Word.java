package model;

public class Word {
    int id;
    String word;

    public Word() {
    }

    public Word(String word) {
        this.word = word.toLowerCase();
    }

    public Word(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
