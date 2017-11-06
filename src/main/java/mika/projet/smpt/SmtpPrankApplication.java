package mika.projet.smpt;


import mika.projet.smpt.client.SmtpClientImpl;
import mika.projet.smpt.config.Config;
import mika.projet.smpt.config.IConfig;
import mika.projet.smpt.model.prank.SecretSanta;
import mika.projet.smpt.model.prank.SecretSantaGenerator;

import java.io.IOException;
import java.util.List;

/**
 * Created by Michael Spierer
 */
public class SmtpPrankApplication {

    public static void main(String[] args) throws IOException {
        IConfig config = new Config();
        SecretSantaGenerator secretSantaGenerator = new SecretSantaGenerator(config);

        SmtpClientImpl sci = new SmtpClientImpl(config.getSmtpServerAddress(),config.getSmtpServerPort());

        List<SecretSanta> secretSantas = secretSantaGenerator.generatePranks();
        for(SecretSanta p : secretSantas){
            sci.sendMessage(p);
        }

    }
}
