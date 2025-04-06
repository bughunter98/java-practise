package org.example.Streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfThreadsInParallelStream {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4,5,6,7,8,9,10,10);
        AtomicInteger count = new AtomicInteger(0);
        int value = data.stream().max(Comparator.naturalOrder()).get();

        data.forEach(val->{
            if(val==value){
                count.getAndIncrement();
            }
        });
        System.out.println(count);


        /*In Java, Stream.peek() is an intermediate operation that allows you to perform a non-mutating action on each element
        of the stream as it is processed. It is mainly used for debugging purposes, such as inspecting the elements as they flow
        through the stream pipeline.The peek() method accepts a Consumer (a functional interface) that is applied to each element
        of the stream, but it does not modify the elements. Importantly, peek() does not trigger any processing by itself; it
        is only invoked when a terminal operation (like forEach, collect, reduce, etc.) is called on the stream.*/
        data.parallelStream().
                peek(val->
                System.out.println(Thread.currentThread().getName())).forEach(val->{/*doinng nothing*/});
        // if we dont write foreach then the result of peek is ignored . so we are doing foreach



    }
}
