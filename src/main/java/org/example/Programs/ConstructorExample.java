package org.example.Programs;

class Data{
    String name;
    int age;

    public String getName() {
        return name;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public void setAge(int newAge){
        this.age=newAge;
    }
    public int getAge() {
        return age;
    }
    public Data(){
        this("Developer");
        System.out.println("empty constructor called");
    }
    public Data(String name , int age){
        System.out.println("Name is : "+name+" age is : "+age);
    }
    public Data(String occupation){
        this("Sai",3);
        System.out.println("Occupation is : "+occupation);
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        System.out.println("main method");
        Data data = new Data();
        /*data.setAge(2);
        data.setName("Sai");*/
    }
}
