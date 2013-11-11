package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/8/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contact implements Comparable {
    private String name, phone, birthDate;
    private boolean isGreaterThan;

    public Contact(String name, String phone, String birthDate){
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(String birthdate) {
        this.birthDate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!birthDate.equals(contact.birthDate)) return false;
        if (!name.equals(contact.name)) return false;
        if (!phone.equals(contact.phone)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }


    @Override
    public int compareTo(Object o) {
        int result;
        Contact otherContact = (Contact)o;
        String otherContactName = otherContact.getName();
        if(this.isLessThan(otherContactName)){
            result= -1;
        }
        else if(!this.isLessThan(otherContactName)){
            result = 1;
        }
        else
            result = 0;
        return result;
    }

    public boolean isLessThan(String name){
        boolean hasBeenDetermined = false; // has determined which string is greater
        char[] nameChars = name.toCharArray();
        char[] currentNameChars = this.getName().toCharArray();
        int count = 0;
        do{
           if(nameChars[count]>currentNameChars[count]){
               isGreaterThan = true;
               hasBeenDetermined = true;
           }
            else if(nameChars[count]<currentNameChars[count]){
               isGreaterThan = false;
               hasBeenDetermined = true;
           }
            else
               count++;
        } while(!hasBeenDetermined && (count < nameChars.length && count < currentNameChars.length));

        return isGreaterThan;
    }
}
