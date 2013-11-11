package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/9/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactByPhoneNumber extends Contact implements Comparable {
    private boolean isGreaterThan;

    public ContactByPhoneNumber(String name, String phone, String birthDate){
        super(name, phone, birthDate);
    }

    public ContactByPhoneNumber(Contact contact){
        super(contact.getName(), contact.getPhone(), contact.getBirthdate());
    }

    @Override
    public int compareTo(Object o) {
        int result;
        Contact otherContact = (Contact)o;
        String otherContactPhone = otherContact.getPhone();
        if(this.isLessThan(otherContactPhone)){
            result= -1;
        }
        else if(!this.isLessThan(otherContactPhone)){
            result = 1;
        }
        else
            result = 0;
        return result;
    }

    public boolean isLessThan(String phone){
        boolean hasBeenDetermined = false; // has determined which string is greater
        char[] nameChars = phone.toCharArray();
        char[] currentNameChars = this.getPhone().toCharArray();
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
