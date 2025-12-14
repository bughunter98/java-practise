package org.example.Programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparator implements Comparator<StudentComparator> {

    public double gpa;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
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

    String name;
    int age;

    public StudentComparator(String name, int age, double marks) {
        this.name = name;
        this.age=age;
        this.gpa=marks;
    }
    public StudentComparator(){

    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + '}';
    }

    public int compare(StudentComparator s1,StudentComparator s2){
        // Advanced logic: Sort primarily by GPA (descending),
        // then by name (ascending), and finally by age (ascending).

        // 1. Compare by GPA (descending)
        int gpaComparison = Double.compare(s2.gpa, s1.gpa); // s2 vs s1 for descending order
        if (gpaComparison != 0) {
            return gpaComparison;
        }

        // 2. If GPAs are equal, compare by Name (ascending)
        int nameComparison = s1.name.compareTo(s2.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        // 3. If names are also equal, compare by Age (ascending)
        return Integer.compare(s1.age, s2.age);
    }

    public static void main(String[] args) {
        List<StudentComparator> students = new ArrayList<>();
        students.add(new StudentComparator("Alice", 20, 3.8));
        students.add(new StudentComparator("Bob", 22, 3.5));
        students.add(new StudentComparator("Charlie", 21, 3.8));
        students.add(new StudentComparator("David", 19, 3.5));
        students.add(new StudentComparator("Alice", 21, 3.8)); // Another Alice for age comparison

        System.out.println("Before sorting:");
        for (StudentComparator s : students) {
            System.out.println(s);
        }

        // Sort using the custom StudentComparator approach 1
        Collections.sort(students, new StudentComparator());

        System.out.println("\nAfter sorting with StudentComparator:");
        for (StudentComparator s : students) {
            System.out.println(s);
        }

        System.out.println("**********************************************************************************************");
        //approach 2
        // Primary sort: GPA descending (note the reversed order for descending numbers)

        Comparator<StudentComparator> stu = Comparator.comparingDouble(StudentComparator::getGpa).reversed()
                // Secondary sort: Name ascending
                .thenComparing(StudentComparator::getName)
                // Tertiary sort: Age ascending
                .thenComparing(StudentComparator::getAge);

        students.sort(stu);

        for (StudentComparator s : students) {
            System.out.println(s);
        }
    }
}
