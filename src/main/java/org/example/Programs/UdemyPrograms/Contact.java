package org.example.Programs.UdemyPrograms;

public class Contact {
    // write code here
    private String name;
    private String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Static method to create a new contact
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}