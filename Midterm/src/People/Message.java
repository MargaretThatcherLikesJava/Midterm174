/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

/**
 *
 * @author chee
 */
public class Message {
    
    private final Person _sender;
    private final Person _recipient;
    private final String _text;
    
    public Message(Person sender, Person recipient, String text) {
        _sender = sender;
        _recipient = recipient;
        _text = text;
    }
    
    public Person getSender() {
        return _sender;
    }
    
    public Person getRecipient() {
        return _recipient;
    }
    
    public String getText() {
        return _text;
    }
    
    public String toString() {
        String displaySender = "Sender: " + _sender;
        String displayRecipient = "Recipient: " + _recipient;
        String displayText = "Text: " + _text;
        return displaySender + "\n" + displayRecipient + "\n" + displayText;
    }
    
}
