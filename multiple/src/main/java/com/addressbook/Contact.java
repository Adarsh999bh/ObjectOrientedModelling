package com.addressbook;

public class Contact{
    String firstName,lastName,town,city,email,zip,phoneNumber,state;

    Contact(String firstName,String lastName,String town,String city,String email,String zip,String phoneNumber,String state){
        this.town=town;
        this.firstName=firstName;
        this.lastName=lastName;
        this.city=city;
        this.email=email;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
        this.state=state;
    }

    public void displayContactDetails(){
        System.out.println("First name : "+this.firstName);
        System.out.println("Last name : "+this.lastName);
        System.out.println("Town : "+this.town);
        System.out.println("City : "+this.city);
        System.out.println("State : "+this.state);
        System.out.println("Zip : "+this.zip);
        System.out.println("Phone number : "+this.phoneNumber);
        System.out.println("Email : "+this.email);
    }
}