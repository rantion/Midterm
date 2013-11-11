package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/9/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactByBirthDate extends Contact implements Comparable {
    private boolean isGreaterThan;

    public ContactByBirthDate (String name, String phone, String birthDate){
        super(name, phone, birthDate);
    }

    public ContactByBirthDate (Contact contact){
        super(contact.getName(), contact.getPhone(), contact.getBirthdate());
    }

    @Override
    public int compareTo(Object o) {
        int result;
        Contact otherContact = (Contact)o;
        String otherContactDate = otherContact.getBirthdate();
        if(this.isLessThan(otherContactDate)){
            result= -1;
        }
        else if(!this.isLessThan(otherContactDate)){
            result = 1;
        }
        else
            result = 0;
        return result;
    }

    public boolean isLessThan(String date){
        boolean hasBeenDetermined = false; // has determined which string is greater
        char[] nameChars = date.toCharArray();
        char[] currentNameChars = this.getBirthdate().toCharArray();
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
