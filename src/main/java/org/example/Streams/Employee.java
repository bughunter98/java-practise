package org.example.Streams;


public class Employee {
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empSalary=" + empSalary +
                ", department=" + deptartment +
                '}';
    }

    private int empId;
    private int empSalary;
    private String deptartment;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }
    public String getDepartment() {
        return deptartment;
    }
    public void setDeptartment(String deptartment) {
        this.deptartment = deptartment;
    }



    public Employee(int empId, int empSalary,String department) {
        this.empId = empId;
        this.empSalary = empSalary;
        this.deptartment = department;
    }
    public Employee(){

    }
}
