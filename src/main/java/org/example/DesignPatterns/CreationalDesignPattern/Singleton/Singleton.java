package org.example.DesignPatterns.CreationalDesignPattern.Singleton;

public class Singleton {
    private static Singleton object;
    // private constructor to force use of getInstance() to create Singleton object
    private Singleton() {

    }
    public static Singleton getInstance(){
        synchronized (Singleton.class){
            if (object==null) {
                object = new Singleton();
            }
        }
        return object;
    }
    public static void doSomething()
    {
        System.out.println("Something is Done.");
    }
}

class Main{
    public static void main(String[] args) {
        Singleton.getInstance().doSomething();
        //if u want to verify the object is created once or multiple times we can verify with the hashcode
    }
}