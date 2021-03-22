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
public class Person implements Messagable {
    
    private String _firstName;
    private String _lastName;
    private static int _id;
    protected ArrayList<Person> _friendsList = new ArrayList<Person>();
    protected ArrayList<Message> _messagesList = new ArrayList<Message>();
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
     * Check if the person is blocked. Return true if so.
     * @param p
     * @return 
     */
    public boolean isBlocked(Person p) {
        boolean blocked = false;
        if (_blockedList == null) { // if blocked list empty, not blocked
            blocked = false;
        } 
        for (int i = 0; i < _blockedList.size(); i++) {
            if (p.equals(_blockedList.get(i))) {
                blocked = true;
                //System.out.println(p + "is BLOCKED  by " + this._firstName);
            }
        }
        return blocked;
    }
    
    /**
     * Check if the person is a duplicate on friends list. Return true if so.
     * @param p
     * @return 
     */
    public boolean isDuplicate(Person p, ArrayList<Person> pList) {
        boolean duplicate = false;
        if (pList == null) { // if friends list empty, not duplicate
            duplicate = false;
        }
        for (int i = 0; i < pList.size(); i++) {
            if (p.equals(pList.get(i))) {
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
        if (!isBlocked(p) && !isDuplicate(p, _friendsList)) { // check blocked, duplicate
            addedFriend = true;
            this._friendsList.add(p);
            // ADD OTHER FRIEND
            // MESSAGE OTHER FRIEND
        } else {
            addedFriend = false;
        }
        return addedFriend;
    }
    
    /**
     * Adds one person object to another person's blocked list
     * @param p
     * @return boolean 
     */
    public boolean addBlock(Person p) {
        boolean hasBlocked = false;
        if(!isBlocked(p) && !isDuplicate(p, _blockedList)) {
            this._blockedList.add(p);
        } else {
            hasBlocked = false;
        }
        return hasBlocked;
    }
    
    public boolean receiveMessage(Message m, Person p) {
        boolean receivedMessage = false;
        if (!isBlocked(p)) {
            _messagesList.add(m);
            receivedMessage = true;
        }
        return receivedMessage;
    }
    
    public String toString() {
        String displayFirstName = _firstName;
        String displayLastName = _lastName;
        String displayId = "ID: " + _id;
        String displayFList = "Friends List: " + _friendsList.toString();
        String displayMList = "Message List: " + _messagesList.toString();
        String displayBList = "Blocked List: " + _blockedList.toString();
        
        return displayFirstName + " " + displayLastName  + "\n" + displayId + "\n"+ displayFList + "\n" + displayMList + "\n"
                + displayBList + "\n";
    }
    
}
