package org.example.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsGroupBy {
    public static void main(String[] args) {
        //  Given a list of integers, group them by even and odd numbers. The result should be a Map<Boolean, List<Integer>>, where true indicates even numbers and false indicates odd numbers.
        // Example Input: [1, 2, 3, 4, 5, 6, 7]
        // output : {false=[1, 3, 5, 7], true=[2, 4, 6]}
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);
        Map<Boolean, List<Integer>> output = values.stream().collect(Collectors.groupingBy(val -> val%2==0));
        System.out.println(output);
        /*
        Problem: Given a list of strings, group them by their length. The result should be a Map<Integer, List<String>>, where the key is the length of the string, and the value is the list of strings with that length.
        Example Input: ["apple", "banana", "pear", "kiwi", "grape", "cherry"]
        Expected Output: {4=[pear, kiwi], 5=[apple, grape], 6=[banana, cherry]} * */

        List<String> fruitsList = Arrays.asList("apple", "banana", "pear", "kiwi", "grape", "cherry");

        Map<Integer, List<String>> output1 = fruitsList.stream().collect(Collectors.groupingBy(val->val.length()));
        System.out.println(output1);

        /*
        Problem: Given a list of words, group them by their first character. The result should be a Map<Character, List<String>>, where the key is the first character of the word, and the value is the list of words starting with that character.
        Example Input: ["apple", "banana", "apricot", "cherry", "blueberry", "carrot"]
        Expected output = {a=[apple, apricot], b=[banana, blueberry], c=[cherry, carrot]}
        * */
        List<String> fruitsList1 = Arrays.asList("apple", "banana", "apricot", "cherry", "blueberry", "carrot");
        Map<Character, List<String>> output2 = fruitsList1.stream().collect(Collectors.groupingBy(val -> val.charAt(0)));
        System.out.println(output2);

        /*Problem: Given a list of words, group them by their length and count how many words exist for each length. The result should be a Map<Integer, Long>, where the key is the length of the word and the value is the count of words with that length.
        Example Input: ["apple", "banana", "kiwi", "pear", "grape", "cherry"]
        Expected Output: {4=2, 5=2, 6=2}*/
        List<String> fruitsList2 =  Arrays.asList("apple", "banana", "kiwi", "pear", "grape", "cherry");
        Map<Integer, Long> output3 = fruitsList2.stream().collect(Collectors.groupingBy(val -> val.length(), Collectors.counting()));
        System.out.println(output3);

        /*Problem: Given a list of Person objects (with fields name and age), group them by age, but also collect them into sets (to remove duplicates).
        The result should be a Map<Integer, Set<Person>>, where the key is the age, and the value is the set of Person objects with that age.*/

        // expected output {25=[Person{Bob, 25}, Person{Charlie, 25}], 30=[Person{Alice, 30}, Person{Dave, 30}]}
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 30),
                new Person("Charlie", 25),
                new Person("Dave", 30)
        );

        Map<Integer, Set<Person>> output4 = people.stream().collect(Collectors.groupingBy(person -> person.getAge(), Collectors.toSet()));
        //System.out.println(output4);
        output4.forEach((age,persons) -> {
            System.out.print(age+"="+persons);
        });
        System.out.println();


        /*Problem: Given a list of Order objects, group the orders by customer, and then group those orders by the product type within each customer. The Order object has a customerName, productType, and quantity attribute. The result should be a Map<String, Map<String, List<Order>>>, w
        where the first map groups by customer name, and the nested map groups by product type.*/

        // expected outout : {Alice={Electronics=[Order{Alice, Electronics, 2}], Clothing=[Order{Alice, Clothing, 3}]},
        // Bob={Clothing=[Order{Bob, Clothing, 5}], Electronics=[Order{Bob, Electronics, 1}]}}

        List<Order> orders = Arrays.asList(
                new Order("Alice", "Electronics", 2),
                new Order("Bob", "Clothing", 5),
                new Order("Alice", "Clothing", 3),
                new Order("Bob", "Electronics", 1)
        );
        Map<String, Map<String, List<Order>>> output5 = orders.stream().collect(Collectors.groupingBy(order -> order.customerName,
                Collectors.groupingBy(ord -> ord.productType)));
        //System.out.println(output5);
        output5.forEach((customer,productMap)->{
            System.out.print(customer+"="+productMap);
        });


    }


}
class Order {
    String customerName;
    String productType;
    int quantity;

    Order(String customerName, String productType, int quantity) {
        this.customerName = customerName;
        this.productType = productType;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Order{" + customerName + ", " + productType + ", " + quantity + "}";
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getters, toString(), etc.
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
    @Override
    public String toString() {
        return "Person{" + name + ", " + age + "}"; // Format: Person{Bob, 25}
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}
