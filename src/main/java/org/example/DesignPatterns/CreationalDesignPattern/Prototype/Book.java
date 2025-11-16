package org.example.DesignPatterns.CreationalDesignPattern.Prototype;

public class Book {
    private int bid;
    private String bName;


    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bName='" + bName + '\'' +
                '}';
    }
}
