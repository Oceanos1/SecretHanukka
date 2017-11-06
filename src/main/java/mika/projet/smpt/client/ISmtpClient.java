package mika.projet.smpt.client;

import mika.projet.smpt.model.secret.SecretSuvgania;

import java.io.IOException;

/**
 * Created by Michael Spierer
 */
public interface ISmtpClient {

    void sendMessage(SecretSuvgania p) throws IOException;

}
