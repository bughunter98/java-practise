package org.example.Programs;

import java.util.PriorityQueue;

//priority Queue Example
public class CustomerOrder {

    public static void main(String[] args) {
        PriorityQueue<String> orders =  new PriorityQueue<>();
        orders.add("A23563");
        orders.add("A15362");
        orders.add("A35263");
        String order;
        while ((order = orders.poll())!=null){
            System.out.println(order+"");
        }
    }
}
