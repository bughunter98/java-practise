package org.example.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounterWithThreads {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);


        Thread t1 = new Thread(()->{

                for (int i=0;i<1000;i++){
                    counter.getAndIncrement();
                }

        });
        Thread t2 = new Thread(()->{

                for (int i = 0; i < 1000; i++) {
                    counter.getAndIncrement();
                }
        });

        // this is not parallel since t2 wont start until t1 execution is completed.
        //t1.start();
        //t1.join();
        //t2.start();
        //t2.join();


        // this is parallel approach where 2 threads are not dependent on each other and run paralelly by incrementing the counter.
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter);


    }
}
