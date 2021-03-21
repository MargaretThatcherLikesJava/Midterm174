/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;
import People.*;

/**
 *
 * @author chee
 */
public class Midterm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Person person1 = new Person("George", "Washington");
        Person person2 = new Person("Abraham", "Lincoln");
        
        person1.addFriend(person2);
        System.out.println(person1);
        System.out.println(person2);
        
    }
    
}
