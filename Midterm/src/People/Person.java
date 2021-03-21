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
public class Person implements Friendable, Messagable {
    
    private String _firstName;
    private String _lastName;
    private static int _id = 0;
    protected ArrayList<Person> _friendsList = new ArrayList<Person>();
    protected ArrayList<String> _messagesList = new ArrayList<String>();
    protected ArrayList<Person> _blockedList = new ArrayList<Person>();
    
    public Person(String firstName, String lastName) {
        
        _firstName = firstName;
        _lastName = lastName;
        _id++;
        
    }
    
    
    /**
     * Compares two people objects based on their first and last name
     * @param x
     * @param y
     * @return 
     */
    public boolean equals(Person p) {
        boolean isEquals = false;
        if (getClass() == p.getClass()){
            isEquals = true;
        } else {
            isEquals = false;
        }
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
    
    //@Override
    public String toString() {
        String displayFList = "Friends List: " + _friendsList.toString();
        String displayMList = "Message List: " + _messagesList.toString();
        String displayId = "ID: " + _id;
        
        return _firstName + " " + _lastName  + "\n" + displayId + "\n"+ displayFList + "\n" + displayMList + "\n";
    }
    
}
