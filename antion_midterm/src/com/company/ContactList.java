package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/8/13
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactList {

    ArrayList<Contact> contacts = new ArrayList<Contact>();

    public ContactList(){

    }

    public void addToList(Contact contactToAdd){
        contacts.add(contactToAdd);
    }

    public int getContactsSize(){
           return contacts.size();
    }

    public void printContacts(){
        //sort();
        Collections.sort(contacts);
        int i = 1;
        for(Contact con: contacts){
            System.out.println(+i+") Name: "+con.getName()+" Phone: "+con.getPhone()+ " BirthDate: "+con.getBirthdate());
            i++;
        }
    }

    public void printContact(Contact contactToPrint){
        System.out.println("\nName: "+contactToPrint.getName()
                +"\nPhone: "+contactToPrint.getPhone()
                +"\nBirth date: "+contactToPrint.getBirthdate()+"\n");


    }

    public void sort(){
        int length = getContactsSize();
        for(int i = 0; i< length;i++){
           boolean swapped = false;
            for(int j = length - 1; j>i;j--){
                if(contacts.get(j).compareTo(contacts.get(j-1))==-1){
                    swap(j,j-1) ;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public void swap(int contact1, int contact2){
        Contact contact_1 = contacts.get(contact1);
        Contact contact_2 = contacts.get(contact2);
        Contact temp = contact_1;
        contact_1 = contact_2;
        contact_2 = temp;
        contacts.remove(contact1);
        contacts.add(contact1, contact_1);
        contacts.remove(contact2);
        contacts.add(contact2, contact_2);
    }



}
