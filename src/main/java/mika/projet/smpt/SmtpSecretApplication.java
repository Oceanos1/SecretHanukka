package mika.projet.smpt;


import mika.projet.smpt.client.SmtpClientImpl;
import mika.projet.smpt.config.Config;
import mika.projet.smpt.config.IConfig;
import mika.projet.smpt.model.secret.SecretSuvgania;
import mika.projet.smpt.model.secret.SecretSuvganiaGenerator;

import java.io.IOException;
import java.util.List;

/**
 * Created by Michael Spierer
 */
public class SmtpSecretApplication {

    public static void main(String[] args) throws IOException {
        IConfig config = new Config();
        SecretSuvganiaGenerator secretSuvganiaGenerator = new SecretSuvganiaGenerator(config);

        SmtpClientImpl sci = new SmtpClientImpl(config.getSmtpServerAddress(),config.getSmtpServerPort());

        List<SecretSuvgania> secretSuvganias = secretSuvganiaGenerator.generatePranks();
        for(SecretSuvgania p : secretSuvganias){
            sci.sendMessage(p);
        }

    }
}
