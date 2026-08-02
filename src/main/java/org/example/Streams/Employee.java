package org.example.Streams;


public class Employee {
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                "name=" + name +
                ", empSalary=" + empSalary +
                ", department=" + deptartment +
                ", City=" + city +
                '}';
    }

    private int empId;
    private String name;
    private int empSalary;
    private String deptartment;
    private String city;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpSalary() {
        return empSalary;
    }
    public String getCity() { return city; }
    public String getName() { return name; }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }
    public String getDepartment() {
        return deptartment;
    }
    public void setDeptartment(String deptartment) {
        this.deptartment = deptartment;
    }



    public Employee(int empId, int empSalary,String department,String city,String name) {
        this.empId = empId;
        this.empSalary = empSalary;
        this.deptartment = department;
        this.city = city;
        this.name = name;
    }
    public Employee(){

    }
    public Employee(String name, int empSalary) {
        this.empSalary = empSalary;
        this.name = name;
    }
}
