package model;

public class Meaning {
    int id;
    String mean;

    public Meaning() {
    }

    public Meaning(String mean) {
        this.mean = mean;
    }

    public Meaning(int id, String mean) {
        this.id = id;
        this.mean = mean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
