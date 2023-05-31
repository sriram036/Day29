package com.bridgelabz;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    private String addressBookName;

    public AddressBook() {
    }
    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public void getData(String firstName) {
        boolean isFound = contacts.stream().anyMatch(contact -> contact.getFirstName().equals(firstName));
        if (isFound == true) {
            System.out.println("The Entered contact person is already available in the given address book.");
        }
        else {
            Contact contactPerson = new Contact();
            Scanner scanner = new Scanner(System.in);
            contactPerson.setFirstName(firstName);
            System.out.println("Enter Person Last Name : ");
            String lastName = scanner.next();
            contactPerson.setLastName(lastName);
            System.out.println("Enter Person City : ");
            String city = scanner.next();
            contactPerson.setCity(city);
            System.out.println("Enter Person State : ");
            String state = scanner.next();
            contactPerson.setState(state);
            System.out.println("Enter Person Zipcode : ");
            int zipcode = scanner.nextInt();
            contactPerson.setZip(zipcode);
            System.out.println("Enter person Phone Number : ");
            long phoneNumber = scanner.nextLong();
            contactPerson.setPhoneNumber(phoneNumber);
            System.out.println("Enter person Email ID : ");
            String email = scanner.next();
            contactPerson.setEmail(email);
            contacts.add(contactPerson);
        }
    }

    public boolean editValue(String name) {
        boolean isFound = false;
        for (int i = 0; i < contacts.size(); i++) {
            Scanner scanner = new Scanner(System.in);
            if (contacts.get(i).getFirstName().equals(name)) {
                isFound = true;
                System.out.println("Enter Person First Name : ");
                String firstName = scanner.next();
                contacts.get(i).setFirstName(firstName);
                System.out.println("Enter Person Last Name : ");
                String lastName = scanner.next();
                contacts.get(i).setLastName(lastName);
                System.out.println("Enter Person City : ");
                String city = scanner.next();
                contacts.get(i).setCity(city);
                System.out.println("Enter Person State : ");
                String state = scanner.next();
                contacts.get(i).setState(state);
                System.out.println("Enter Person Zipcode : ");
                int zipcode = scanner.nextInt();
                contacts.get(i).setZip(zipcode);
                System.out.println("Enter person Phone Number : ");
                long phoneNumber = scanner.nextLong();
                contacts.get(i).setPhoneNumber(phoneNumber);
                System.out.println("Enter person Email ID : ");
                String email = scanner.next();
                contacts.get(i).setEmail(email);
                break;
            }
        }
        return isFound;
    }

    public boolean delete(String name) {
        boolean isFound = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(name)) {
                isFound = true;
                contacts.remove(i);
            }
        }
        return isFound;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressBookName='" + addressBookName + '\'' +
                ", contacts=" + contacts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(contacts, that.contacts) && Objects.equals(addressBookName, that.addressBookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contacts, addressBookName);
    }
}
