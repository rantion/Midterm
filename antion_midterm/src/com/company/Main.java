package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private boolean isRunning = true;
    private ContactList contactList = new ContactList();
    private ContactList contactListPhone = new ContactList();
    private ContactList contactListDate = new ContactList();
    private Scanner scan = new Scanner(System.in);
    private HashMap<String, Contact> hashMap = new HashMap<String,Contact>();

    private PerformAction[] actions = {
            new Quit(),
            new PrintContactsByName(),
            new PrintContactsByNumber(),
            new PrintContactsByBirthDate(),
            new PrintSpecificContact()
    };


    public static void main(String[] args) {
	    Main newMain = new Main ();
    }

    public Main(){
        readFile();
        do
        {
            promptAction();
        }
        while (isRunning);

    }

    private int getActionNumber(){
        int actionNumber = scan.nextInt();
        scan.nextLine();
        return actionNumber;

    }

    private  void promptAction() {
        int menuChoice = -1;
        do {
            try {//promptUser for the action
                promptForAction();
                //get the action number from the user
                menuChoice = getActionNumber();
                // execute the specified action
                if (isValidActionNumber(menuChoice)) {
                    executeAction(menuChoice);
                }
                else{
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Please enter a number between 0 and "+ (actions.length-1));
            }
        }
        while (!isValidActionNumber(menuChoice));
    }

    private  void executeAction(int menuChoice) {
        PerformAction action = actions[menuChoice];
        action.execute_Action();
    }

    private boolean isValidActionNumber(int actionNumber) {
        return (actionNumber > -1 && actionNumber < actions.length);
    }

    public void promptForAction() {
        for(int i=0; i < actions.length; i++)
            System.out.println("" +i+") "+ actions[i].getPrompt());

    }


    private void viewSpecificContact() {
        System.out.println("Please enter the name of the contact you would like to see");
        try{
        String contactToSee = scan.nextLine().toUpperCase();
        Contact ToSee = hashMap.get(contactToSee);
        contactList.printContact(ToSee);
        }
        catch(Exception e){
            System.out.println("Sorry that does not appear to be the name of a contact.");
        }
    }

    public void readFile(){
        BufferedReader reader = null;

        try {
            File file = new File("/Users/Rachel/csc-180/Contacts.csv");
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tempContact = line.split(",");
                String name = tempContact[0];
                String phone = tempContact[1];
                String birthDate = tempContact[2];

                Contact newContact = new Contact(name, phone, birthDate);
                ContactByPhoneNumber contactByPhoneNumber = new ContactByPhoneNumber(newContact);
                ContactByBirthDate contactByBirthDate = new ContactByBirthDate(newContact);
                contactList.addToList(newContact);
                contactListPhone.addToList(contactByPhoneNumber);
                contactListDate.addToList(contactByBirthDate);
                hashMap.put(newContact.getName(),newContact);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class PrintContactsByName extends PerformAction{
       public PrintContactsByName(){
           super("View all contacts by Name");
       }
     public void execute_Action(){contactList.printContacts();}
   }

    public class PrintContactsByNumber extends PerformAction{
        public PrintContactsByNumber(){
            super("View all contacts by Number");
        }
        public void execute_Action(){contactListPhone.printContacts();}
    }

    public class PrintContactsByBirthDate extends PerformAction{
        public PrintContactsByBirthDate(){
            super("View all contacts by Birth Date");
        }
        public void execute_Action(){contactListDate.printContacts();}
    }

    public class PrintSpecificContact extends PerformAction{
        public PrintSpecificContact(){
            super("View a Specific Contact");
        }
        public void execute_Action(){viewSpecificContact();}
    }

    public class Quit extends PerformAction{

        public Quit(){
            super("Quit");
        }
        public void execute_Action(){isRunning = false;}
    }
}