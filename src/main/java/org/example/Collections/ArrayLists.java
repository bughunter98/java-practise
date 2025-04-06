package org.example.Collections;

import java.util.*;

public class ArrayLists {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while(flag){
            printActions();
            switch (Integer.parseInt(scanner.nextLine())){ // using scsnner.nextInt is not working here
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }
    private static void addItems(ArrayList<String> groceries){
        System.out.println(" add items seperated by comma");
        String[] items = scanner.nextLine().split(",");
        groceries.addAll(List.of(items).stream().map(String::trim).toList()); // because items may have spce
        // in the staarting which will cause issue while sorting
        // so removing the spaces using trim.
    }
    private static void removeItems(ArrayList<String> groceries){
        System.out.println(" remove items to be deleted [seperated by comma] ");
        String[] items = scanner.nextLine().split(",");
        //Arrays.asList(items).stream().filter(groceries::remove);
        System.out.println("Array List after removing : "+ Arrays.toString(items));
        Arrays.asList(items).stream().map(String::trim).filter(groceries::remove).forEach(System.out::println);
    }

    private static void printActions() {
        String textBlock = """
                Available Actions :
                0 - to shutdown
                1 - to add item(s) to list [comma delimited list]
                2 - to remove any item(s) to list [comma delimited list]
                Enter a number for the action u want to perform : 
                """;
        System.out.println(textBlock+ " ");
    }

}
