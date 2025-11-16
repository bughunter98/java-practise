package org.example.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreamsPractise {
    public static void main(String[] args) {
        List<Integer> employeeList = Arrays.asList(3000,5000,2000,4000,1000);
        List<Employee> employeesList = Arrays.asList(new Employee(1,3000,"DEV"),
                new Employee(2,5000,"HR"),new Employee(3,2000,"QA")
                ,new Employee(4,4000,"DevOps"),new Employee(5,1000,"AI")
        ,new Employee(6,1500,"QA"));
        //1. sort list of employees by salary desc
        System.out.println(employeeList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(employeesList.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .collect(Collectors.toList())); // “Java implicitly calls toString() whenever an object is used where a String is expected,
        // such as printing, concatenation, logging, or inside collections’ toString() methods.
        // That’s why we see readable output only after overriding toString().”
        // “Java implicitly calls toString() whenever an object is used where a String is expected, such as printing,
        // concatenation, logging, or inside collections’ toString() methods. That’s why we see readable output only
        // after overriding toString().”
        // ************************************************************************************************************
        // 2 . Sort employees by department then salary
        System.out.println(employeesList.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getEmpSalary)).toList());
        // 3. grouping by example
        System.out.println(employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment)));
        // this will give the ascending order of depts that are grouped by length.
        System.out.println(employeesList.stream().map(Employee::getDepartment).collect(Collectors.groupingBy(String::length)));
        // for descending order
        System.out.println(employeesList.stream().map(Employee::getDepartment).collect(Collectors.groupingBy(String::length,
                ()->new TreeMap<>(Comparator.reverseOrder()),
                Collectors.toList())));
        // 4. Sum all salaries in department using groupingby
        System.out.println(employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingInt(Employee::getEmpSalary))));
        // 5. Sum all numbers using reduce()
        // if we use reduce(Integer::sum) this returns an optional
        System.out.println(employeesList.stream().map(Employee::getEmpSalary).
                reduce(Integer::sum).get());
        // wihtout optional
        // this is how reduce(0,Integaer::sum) works
        /*
        * start = 0
          0 + 3000 = 3000
          3000 + 5000 = 8000
          8000 + 2000 = 10000
          * */
        System.out.println(employeesList.stream().map(Employee::getEmpSalary).
                reduce(0,Integer::sum));

        // 6 . count occurances of each element in a list .
        List<String> alphabetList = Arrays.asList("a","b","a","c","a","b");
        // without stream we can loop and perform the logic
        // when ever number of elements come we need to use counting
        System.out.println(alphabetList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));








    }
}
