package org.example.Programs;

import org.example.DataStructures.Stacks.StackUsingArray.StackUsingArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class StudentComparableInterfaceDemo implements Comparable<StudentComparableInterfaceDemo>{

    String name;
    int marks;

     StudentComparableInterfaceDemo(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(StudentComparableInterfaceDemo other) {
        return this.marks - other.marks;  // ascending order by marks
    }

    @Override
    public String toString() {
        return name + ": " + marks;
    }

    public static void main(String[] args) {
        List<StudentComparableInterfaceDemo> students = new ArrayList<>();
        students.add(new StudentComparableInterfaceDemo("Alice", 85));
        students.add(new StudentComparableInterfaceDemo("Bob", 92));
        students.add(new StudentComparableInterfaceDemo("Charlie", 78));
        Collections.sort(students);

        // The compareTo method is being used in your code, but it's called implicitly by the Java sorting utility, Collections.sort().
        for (StudentComparableInterfaceDemo s: students){
            System.out.println(s);
        }

    }
}
