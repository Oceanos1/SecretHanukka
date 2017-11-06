package mika.projet.smpt.config;

import mika.projet.smpt.model.mail.Personne;

import java.io.IOException;
import java.util.List;

/**
 * Created by Michael Spierer
 */
public interface IConfig {

    List<Personne> loadAddressesFromFile(String filename) throws IOException;

    List<Personne> getVictims();

    List<Personne> getCc();

    List<String> getMessages();

    public String getSmtpServerAddress();

    public int getSmtpServerPort();

}
