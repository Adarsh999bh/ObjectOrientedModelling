package com.addressbook;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook{
    public static Scanner sc=new Scanner(System.in); 
    private static void printOptions(){
        System.out.println("1 : Add Contact\n2 : Edit Contact\n3 : Delete Contact\n4 : Display\n5 : Exit");
    }
    private static Contact getPerson(List<Contact> list,String name){
        for(int i=0;i<list.size();i++){
            if(list.get(i).firstName.equals(name)){
                return list.get(i);
            }
        }
        return null;

    }
    private static void editContactDetails(Contact person){
        System.out.println("Do you want to edit first name ?");
        if(sc.nextLine().equals("yes")){
            person.firstName=sc.nextLine();
        }
        System.out.println("Do you want to edit last name ?");
        if(sc.nextLine().equals("yes")){
            person.lastName=sc.nextLine();
        }
        System.out.println("Do you want to edit Town ?");
        if(sc.nextLine().equals("yes")){
            person.town=sc.nextLine();
        }
        System.out.println("Do you want to edit city ?");
        if(sc.nextLine().equals("yes")){
            person.city=sc.nextLine();
        }
        System.out.println("Do you want to edit state ?");
        if(sc.nextLine().equals("yes")){
            person.state=sc.nextLine();
        }
        System.out.println("Do you want to edit zip ?");
        if(sc.nextLine().equals("yes")){
            person.zip=sc.nextLine();
        }
        System.out.println("Do you want to edit email ?");
        if(sc.nextLine().equals("yes")){
            person.email=sc.nextLine();
        }
        System.out.println("Do you want to edit Phone number ?");
        if(sc.nextLine().equals("yes")){
            person.phoneNumber=sc.nextLine();
        }

    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        List<Contact> list=new ArrayList<>();
        int choice;
        while(true){
            printOptions();
            choice=Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    String firstName,lastName,town,city,email,zip,phoneNumber,state;
                    System.out.print("First name : ");
                    firstName=sc.nextLine();
                    System.out.print("Last name : ");
                    lastName=sc.nextLine();
                    System.out.print("Town : ");
                    town=sc.nextLine();
                    System.out.print("City : ");
                    city=sc.nextLine();
                    System.out.print("State : ");
                    state=sc.nextLine();
                    System.out.print("Zip : ");
                    zip=sc.nextLine();
                    System.out.print("Phone number : ");
                    phoneNumber=sc.nextLine();
                    System.out.print("Email : ");
                    email=sc.nextLine();
                    System.out.println("\n\n");
                    list.add(new Contact(firstName, lastName, town, city, email, zip, phoneNumber, state));
                    break;
                }
                case 2:{
                    System.out.println("enter the name of the contact that you want to edit");
                    Contact person=getPerson(list,sc.nextLine());
                    if(person==null){
                        System.out.println("Contact not found in the address book.!");
                    }
                    else{
                        editContactDetails(person);
                    }
                    break;
                }
                case 3:{
                    System.out.println("enter the name of the contact that you want to edit");
                    Contact person=getPerson(list,sc.nextLine());
                    if(person==null){
                        System.out.println("Contact not found in the address book.!");
                    }
                    else{
                        list.remove(person);
                    }
                    break;
                }
                case 4:{
                    for(int i=0;i<list.size();i++){
                        list.get(i).displayContactDetails();
                        System.out.println("\n\n");
                    }
                    break;
                }
                case 5:{
                    System.exit(0);
                }
            }

        }

    }
}
