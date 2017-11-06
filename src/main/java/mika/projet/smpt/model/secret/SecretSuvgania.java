package mika.projet.smpt.model.secret;

import mika.projet.smpt.model.mail.Personne;

/**
 * Created by Michael Spierer
 */
public class SecretSuvgania {
    private Personne envoyeur;
    private Personne receveur;

    private String messageToSend;

    public SecretSuvgania(Personne envoyeur, Personne receveur, String messageToSend) {
        this.envoyeur = envoyeur;
        this.receveur =receveur;
        this.messageToSend = messageToSend;
    }

    public Personne getEnvoyeur() {
        return envoyeur;
    }

    public Personne getReceveurs() {
        return receveur;
    }

    public String getMessageToSend() {
        return messageToSend;
    }

}
