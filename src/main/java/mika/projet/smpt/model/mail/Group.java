package mika.projet.smpt.model.mail;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Spierer
 */
public class Group {
    Personne sender;
    Personne reciever;

    public Group(){

    }

    public Personne getSender() {
        return sender;
    }

    public void setSender(Personne sender) {
        this.sender = sender;
    }

    public Personne getReciever() {
        return reciever;
    }

    public void setReciever(Personne reciever) {
        this.reciever = reciever;
    }

    public Boolean isValid(){
        return !sender.equals(reciever);
    }
}
