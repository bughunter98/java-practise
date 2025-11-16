package org.example.DesignPatterns.CreationalDesignPattern.Prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable{

    //Note :
    //Invoking Object's clone method on an instance that does not implement
    // the Cloneable interface results in the exception CloneNotSupportedException being thrown.
    private String shopName;
    private List<Book> books =  new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadDataFromDB(){
        // for time being im adding for loop instead of adding DB logic tp fetch the data
        for (int i=1;i<=10;i++){
            Book b = new Book();
            b.setBid(i);
            b.setbName("Book"+i);
            getBooks().add(b);
        }
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        for (Book b: this.getBooks()){
            bs.getBooks().add(b);
        }
        return bs;
    }
}
