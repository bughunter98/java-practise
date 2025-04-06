package org.example.Programs.UdemyPrograms;

import java.util.*;
public class MobilePhone {
    // write code here
    private String myNumber;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String phoneNumber){
        myNumber  = phoneNumber;
        myContacts = new ArrayList<>();
    }

    // here i tried list.contains method but its not giving proper value as
    // list.contains uses equals and hashcode.. tough both objects are same their reference might vary
    // so it will give false . hence i modified it like below
    public boolean addNewContact(Contact contact) {
        // Manually check if a contact with the same name and phone number already exists
        for (Contact existingContact : myContacts) {
            if (existingContact.getName().equalsIgnoreCase(contact.getName()) &&
                    existingContact.getPhoneNumber().equals(contact.getPhoneNumber())) {
                return false;  // Contact already exists, return false
            }
        }

        // If no match was found, add the new contact
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = myContacts.indexOf(oldContact);  // Get the index of oldContact
        if (index != -1) {
            myContacts.set(index, newContact);  // Update the contact
            return true;  // Success
        }
        return false;  // Contact doesn't exist
    }

    public boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        }
        else{
            return false;
        }
    }

    private int findContact(Contact contact){
        if(myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }
        else{
            return -1;
        }
    }
    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i; // Return the index of the contact
            }
        }
        return -1; // Return -1 if the contact doesn't exist
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index != -1) {
            return myContacts.get(index); // Return the contact if found
        }
        return null; // Return null if not found
    }

    // Method to print all contacts
    public void printContacts() {
        if (myContacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }


}