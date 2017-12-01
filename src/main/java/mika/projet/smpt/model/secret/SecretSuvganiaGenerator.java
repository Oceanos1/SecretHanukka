package mika.projet.smpt.model.secret;

import mika.projet.smpt.config.IConfig;
import mika.projet.smpt.model.mail.Group;
import mika.projet.smpt.model.mail.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Michael Spierer
 */
public class SecretSuvganiaGenerator {
    private IConfig config;
    private final int NB_MIN_PARTICIPANTS = 1;

    public SecretSuvganiaGenerator(IConfig config) {
        this.config = config;
    }

    public List<SecretSuvgania> generatePranks() {
        List<String> messages = new ArrayList<String>(config.getMessages());
        List<SecretSuvgania> secretSuvganias = new ArrayList<SecretSuvgania>();

        if(config.getParticipants().size() <= NB_MIN_PARTICIPANTS){
            throw new IllegalStateException("Il n'y a pas assez de participants");
        }
        // Genere des groupes de 2 valides
        List<Group> groups = generateGroups(config.getParticipants());

        for (Group g : groups) {

            String message = "Tu es l'Elfe de Hanukka de "+ g.getReciever().getName()+" "+g.getReciever().getLastName();
            SecretSuvgania p = new SecretSuvgania(config.getOrganisateur(), g.getSecretElf(), messages.get(0)+message);

            secretSuvganias.add(p);
        }
        return secretSuvganias;
    }

    public List<Group> generateGroups(List<Personne> participants) {

        Boolean isValid;
        List<Group> groups;
        do {
            isValid=true;
            groups = new ArrayList<Group>();
            Collections.shuffle(participants);

            for (int i = 0; i < participants.size(); ++i) {
                groups.add(new Group());
                groups.get(i).setSecretElf(participants.get(i));
                groups.get(i).setReciever(participants.get((i+1)%participants.size()));
                isValid &= groups.get(i).isValid();
            }

        }while(!isValid);
        
        return groups;
    }
}
