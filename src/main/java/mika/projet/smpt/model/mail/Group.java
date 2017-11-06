package mika.projet.smpt.model.mail;

/**
 * Created by Michael Spierer
 */
public class Group {
    Personne secretElf;
    Personne reciever;

    public Group(){ }

    public Personne getSecretElf() {
        return secretElf;
    }

    public void setSecretElf(Personne secretElf) {
        this.secretElf = secretElf;
    }

    public Personne getReciever() {
        return reciever;
    }

    public void setReciever(Personne reciever) {
        this.reciever = reciever;
    }

    public Boolean isValid(){
        return !secretElf.equals(reciever);
    }
}
