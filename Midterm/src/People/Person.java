/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;
import java.util.*;
import Interactions.*;

/**
 *
 * @author chee
 */
public class Person {
    
    private String _firstName;
    private String _lastName;
    private static int _id;
    protected ArrayList<Person> _friendsList = new ArrayList<Person>();
    protected ArrayList<String> _messagesList = new ArrayList<String>();
    protected ArrayList<Person> _blockedList = new ArrayList<Person>();
    
    public Person(String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
        _id++;       
    }
    
    public String getFirstName() {
        return _firstName;
    }
    
    public String getLastName() {
        return _lastName;
    }
    
    public int getId() {
        return _id;
    }
    
    /**
     * Compares two people objects based on their first and last name
     * @param p
     * @return boolean
     */
    public boolean equals(Person p) {
        boolean isEquals = this._firstName.equals(p._firstName) && this._lastName.equals(p._lastName);
        return isEquals;
    }
    
    /**
     * Check if the person is already blocked. Return true if so.
     * @param p
     * @return 
     */
    public boolean isBlocked(Person p) {
        boolean blocked = false;
        if (_blockedList == null) { // if blocked list empty, not blocked
            blocked = false;
        } 
        for (int i = 0; i < _blockedList.size(); i++) {
            if (p == _blockedList.get(i)) {
                blocked = true;
            }
        }
        return blocked;
    }
    
    /**
     * Check if the person is a duplicate on friends list. Return true if so.
     * @param p
     * @return 
     */
    public boolean isDuplicate(Person p) {
        boolean duplicate = false;
        if (_friendsList == null) { // if friends list empty, not duplicate
            duplicate = false;
        }
        for (int i = 0; i < _friendsList.size(); i++) {
            if (p == _friendsList.get(i)) {
                duplicate = true;
            }
        }
        return duplicate;
    }
    
    /**
     * Person adds another person to friends list. Reciprocates, and message sent.
     * @param p
     * @return 
     */
    
    public boolean addFriend(Person p) {
        boolean addedFriend = false;    
        if (!isBlocked(p) && !isDuplicate(p)) { // check blocked, duplicate
            addedFriend = true;
            this._friendsList.add(p);
            // ADD OTHER FRIEND
            // MESSAGE OTHER FRIEND
        } else {
            addedFriend = false;
        }
        return addedFriend;
    }
    
    public String toString() {
        String displayFirstName = _firstName;
        String displayLastName = _lastName;
        String displayId = "ID: " + _id;
        String displayFList = "Friends List: " + _friendsList.toString();
        String displayMList = "Message List: " + _messagesList.toString();
        
        return displayFirstName + " " + displayLastName  + "\n" + displayId + "\n"+ displayFList + "\n" + displayMList + "\n";
    }
    
}
