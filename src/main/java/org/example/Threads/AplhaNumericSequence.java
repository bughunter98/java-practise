package org.example.Threads;

public class AplhaNumericSequence {
    static int limit = 26;
    final static Object lock = new Object();
    static boolean isLetter = false;
    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            for (char c= 'A';c<'A'+limit;c++){
                synchronized (lock){
                    while (isLetter){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(c);
                    lock.notify();
                    isLetter = true;
                }
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i=1;i<limit;i++){
                synchronized (lock){
                    while (!isLetter){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(i);
                    lock.notify();
                    isLetter = false;
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
