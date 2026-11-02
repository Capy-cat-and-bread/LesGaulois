package village_gaulois;

import objets.Equipement;
import personnages.Gaulois;

public class Musee {
	private Equipement[] trophees = new Equipement[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
			trophees[nbTrophee] = equipement;
			nbTrophee++;
		}
	}
}
