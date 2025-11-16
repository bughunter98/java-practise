package org.example.DesignPatterns.CreationalDesignPattern.Prototype;

public class Main {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("Novels Store");
        bs.loadDataFromDB();
        BookShop bs1 = /*new BookShop()*/ /*instead of creating an object we clone existing object*/
                bs.clone();
        bs.getBooks().remove(1);
        bs1.setShopName("Book Shop 2");
        System.out.println(bs);
        System.out.println(bs1);
    }
}

// in java jdbc connection while performing CRUD operations there is no need of the JDBC connectivity everytime ,
// creating one object for connection is enough and that object can be used to perform all CRUD operations .
// so here singleton design pattern comes into picture.
