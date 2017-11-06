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

    public SecretSuvganiaGenerator(IConfig config) {
        this.config = config;
    }

    public List<SecretSuvgania> generatePranks() {
        List<String> messages = new ArrayList<String>(config.getMessages());
        List<SecretSuvgania> secretSuvganias = new ArrayList<SecretSuvgania>();

        // Genere des groupes de 2 valides
        List<Group> groups = generateGroups(config.getParticipants());

        for (Group g : groups) {

            String message = "Tu es le Hanukka Elf de "+ g.getReciever().getName()+" "+g.getReciever().getLastName();
            SecretSuvgania p = new SecretSuvgania(config.getOrganisateur(), g.getSecretElf(), messages.get(0)+message);

            secretSuvganias.add(p);
        }
        return secretSuvganias;
    }

    // TODO complexité terrible --> devra etre amélioré dans le futur
    public List<Group> generateGroups(List<Personne> victims) {

        Boolean isValid;
        List<Group> groups;
        do {
            isValid=true;
            groups = new ArrayList<Group>();
            List<Personne> senders = new ArrayList<Personne>(victims);
            List<Personne> recievers = new ArrayList<Personne>(victims);
            Collections.shuffle(senders);
            Collections.shuffle(recievers);

            for (int i = 0; i < victims.size(); ++i) {
                groups.add(new Group());
            }

            int i = 0;
            Group groupCible;
            while (recievers.size() > 0) {
                groupCible = groups.get(i);
                i = (i + 1) % groups.size();
                groupCible.setReciever(recievers.remove(0));
                groupCible.setSecretElf(senders.remove(0));
            }
            //Les n groupes sont crées, maintenant il faut voir s'ils sont valide
            for (Group g: groups) {
                isValid &= g.isValid();
            }
        }while(!isValid);

        return groups;
    }
}
