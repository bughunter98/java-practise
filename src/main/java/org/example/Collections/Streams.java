package org.example.Collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployees();
        List<Employee> employees1 = Employee.getEmployees();
        // 1 . print employees based on their salary (Descending Order)
        /*without stream*/ employeesBySalaryWithoutStream(employees);
        /* with stream*/   employeesBySalaryWithStream(employees1);
    }
    private static void employeesBySalaryWithoutStream(List<Employee> employees) {
        System.out.println("----------------Sorting Employees without Stream-------------------");
        // for ascending order Collections.sort(employees, (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        // for descending order
        // approach 1
        Collections.sort(employees, (e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()));
        //  approach 2  : Collections.sort(employees, Comparator.comparing(Employee::getSalary).reversed());
        for (Employee e: employees){
            System.out.println(/*"ID: " + e.getId() + "*/" Name: " + e.getName() +
                    ", Salary: " + e.getSalary() /*+ ", Joining Date: " + e.getJoiningDate()*/);
        }
    }
    private static void employeesBySalaryWithStream(List<Employee> employees1) {
        System.out.println("----------------Sorting Employees with Stream-------------------");
        /* approach 1 : employees1.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(),e1.getSalary())).
                forEach(e -> System.out.println("ID: " + e.getId() + ", Name: " + e.getName() +
                ", Salary: " + e.getSalary() + ", Joining Date: " + e.getJoiningDate()));
        */
        // approach 2
        employees1.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).
                forEach(e -> System.out.println(/*"ID: " + e.getId() + */"Name: " + e.getName() +
                        ", Salary: " + e.getSalary() /*+ ", Joining Date: " + e.getJoiningDate())*/));
    }
}
