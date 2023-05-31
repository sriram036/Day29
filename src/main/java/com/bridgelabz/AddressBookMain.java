package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        ArrayList<AddressBook> addressBooks = new ArrayList<>();
        AddressBook addressBook = new AddressBook();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add Address Book");
            System.out.println("2.Add Contact");
            System.out.println("3.Display");
            System.out.println("4.Edit");
            System.out.println("5.Delete");
            System.out.println("6.Write address book data to csv file");
            System.out.println("7.Exit");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 : {
                    System.out.println("Enter the Address Book Name to add:");
                    String addressBookName = scanner.next();
                    addressBook = new AddressBook();
                    addressBook.setAddressBookName(addressBookName);
                    addressBooks.add(addressBook);

                }break;
                case 2 : {
                    System.out.println("Enter the address book name to add person:");
                    String name = scanner.next();
                    System.out.println("Enter Person First Name : ");
                    String contactPersonName = scanner.next();
                    for (int i = 0; i < addressBooks.size(); i++) {
                        if (addressBooks.get(i).getAddressBookName().equals(name)) {
                            addressBooks.get(i).getData(contactPersonName);
                        }
                    }
                }break;
                case 3 : {
                    System.out.println(addressBooks);
                }break;
                case 4 : {
                    System.out.println("Enter the contact person name to edit:");
                    String name = scanner.next();
                    boolean isEdited = false;
                    for (int i = 0; i < addressBooks.size(); i++) {
                        if (addressBooks.get(i).editValue(name)){
                            isEdited = true;
                            break;
                        }
                    }
                    if (isEdited) {
                        System.out.println("The person is edited.");
                    }
                    else {
                        System.out.println("The given person name is not existing in the address list.");
                    }
                }break;
                case 5 : {
                    System.out.println("Enter the contact person name to delete:");
                    String name = scanner.next();
                    boolean isDeleted = false;
                    for (int i = 0; i < addressBooks.size(); i++) {
                        if (addressBooks.get(i).delete(name)){
                            isDeleted = true;
                            break;
                        }
                    }

                    if (isDeleted) {
                        System.out.println("The person is deleted.");
                    }
                    else {
                        System.out.println("The given person name is not existing in the address list.");
                    }
                }break;
                case 6 : {
                    try {
                        addressBook.writeArrayListToCsvFile(addressBooks);
                        //System.out.println("Json File Written");
                    }
                    catch (IOException e) {
                        System.out.println(e);
                    }
                }break;
                case 7 : {
                    System.out.println("Thank you! See you soon!");
                    System.exit(0);
                }break;
                default: {
                    System.out.println("Choice is wrong! Please try again!");
                }
            }
        }
        while (choice != 7);
    }
}
