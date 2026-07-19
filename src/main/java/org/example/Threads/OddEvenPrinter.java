package org.example.Threads;

public class OddEvenPrinter {
    public int val =1;
    public int max = 100;

    // if we dont use synchronized to the method then we get illegalMonitorStateException saying current thread is not owner
    // since the objects wont acquire the lock .
    /*
    * Great job on this code! It’s a classic example of thread cooperation. To understand notify(),
    * think of it as a "Tap on the Shoulder" or an "Alarm Clock" for a sleeping thread.
    * Here is the breakdown of exactly what happens in your OddEvenPrinter:
    * 1. The Problem: wait() puts a thread to sleepWhen Thread1 calls wait(), it doesn't just stop; it goes into a "Waiting Room" and gives up its key (the lock) to the OddEvenPrinter object.
    * It will stay there forever unless someone wakes it up.
    * 2. The Solution: notify() wakes them upWhen Thread2 finishes printing an even number, it calls notify().
    * This is essentially Thread2 saying:"Hey! I just finished my turn and changed the value. If anyone is sleeping in the waiting room, wake up now!"
    * 3. The "Gotcha": It doesn't mean "Start Now"This is the part that confuses most beginners.
    * When Thread2 calls notify():The Waiting Thread Wakes Up:
    * Thread1 opens its eyes and moves from the "Waiting Room" to the "Entry Hall" (the Blocked state).The Lock is Still Held: Thread2 still has the key.
    * Thread1 cannot actually start running until Thread2 finishes its synchronized block and releases the lock.The Race: Once Thread2 releases the lock,
    * Thread1 (which was notified) competes to grab that key again to continue from exactly where it left off (right after its wait() call).
    * Why do you need it in your code?Look at your printOdd() logic:Thread1 prints
    * 1.It increments val to 2.It calls notify(). This ensures that if Thread2 was already sleeping (waiting for an even number), it gets a signal to wake up.Thread1 then loops back, sees val is now 2, and hits wait().
    *  It goes to sleep.Because Thread1 called notify() first, Thread2 is now awake and ready to grab the lock and print
    * 2.Without notify(): Both threads would eventually end up calling wait(), and your program would hang forever (Deadlock) because no one would ever signal the other to wake up.Summary for a Beginnerwait():
    * "I'm done for now. I'm going to sleep and leaving the door unlocked.
    * Someone wake me up when it's my turn."notify(): "I just changed something! If someone is sleeping, wake up and get ready to work once I leave the room."Would you like to see what happens if you use notifyAll() instead, or shall we look at how to handle a Spurious Wakeup using a while-loop?*/
    public synchronized void printOdd() {
        while (val<=max){
            if (val%2!=0){
                System.out.println(Thread.currentThread().getName() +" : "+val);
                val++;
                notify();
            }
            else {
                try {
                    wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized void printEven() {
        while (val<=max){
            if (val%2==0){
                System.out.println(Thread.currentThread().getName() +" : "+val);
                val++;
                notify();
            }
            else {
                try {
                    wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter();
        Thread t1 = new Thread(){
            public void run(){
                oddEvenPrinter.printOdd();;
            }
        };

        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                oddEvenPrinter.printEven();;
            }
        };

        t1.setName("Thread1");
        t2.setName("Thread2");


        t2.start();;
    }
}
