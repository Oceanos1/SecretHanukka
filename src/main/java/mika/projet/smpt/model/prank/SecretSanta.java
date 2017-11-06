package mika.projet.smpt.model.prank;

import mika.projet.smpt.model.mail.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Spierer
 */
public class SecretSanta {
    private Personne envoyeur;
    private Personne receveur;
    private final List<Personne> cc;

    private String messageToSend;

    public SecretSanta(Personne envoyeur, Personne receveur, List<Personne> cc, String messageToSend) {
        this.envoyeur = envoyeur;
        this.receveur =receveur;
        this.cc = new ArrayList<Personne>(cc);
        this.messageToSend = messageToSend;
    }

    public Personne getEnvoyeur() {
        return envoyeur;
    }

    public Personne getReceveurs() {
        return receveur;
    }

    public List<Personne> getCc() {
        return cc;
    }

    public String getMessageToSend() {
        return messageToSend;
    }

}
