package org.example.Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Employee {
    private int id;
    private String name ;
    private int salary;
    private Date joiningDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employee(int id, String name, int salary, Date joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }


    public static List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();

        // Creating 10 Employee objects with unique values
        employees.add(new Employee(1, "John Doe", 50000, new Date(120, 0, 15)));  // January 15, 2020
        employees.add(new Employee(2, "Jane Smith", 55000, new Date(119, 5, 10)));  // June 10, 2019
        employees.add(new Employee(3, "Alice Johnson", 60000, new Date(118, 2, 20)));  // March 20, 2018
        employees.add(new Employee(4, "Bob Brown", 45000, new Date(117, 8, 30)));  // September 30, 2017
        employees.add(new Employee(5, "Charlie Davis", 47000, new Date(116, 3, 5)));  // April 5, 2016
        employees.add(new Employee(6, "David Wilson", 65000, new Date(115, 6, 12)));  // July 12, 2015
        employees.add(new Employee(7, "Eva Martinez", 48000, new Date(114, 9, 19)));  // October 19, 2014
        employees.add(new Employee(8, "Frank Garcia", 51000, new Date(113, 1, 25)));  // February 25, 2013
        employees.add(new Employee(9, "Grace Lee", 53000, new Date(112, 10, 5)));  // November 5, 2012
        employees.add(new Employee(10, "Henry Taylor", 60000, new Date(111, 8, 15)));  // September 15, 2011

        return employees;
    }
}
