package village_gaulois;

import objets.Equipement;
import personnages.Gaulois;
import objets.Trophee;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Trophee trophee) {
		if (nbTrophee < trophees.length) {
			trophees[nbTrophee] = trophee;
			nbTrophee++;
		}
	}

	public String extraireInstructionsOCaml() {
		String texte = "let musee = [";
		for (int i = 0; i < nbTrophee; i++) {
			texte += "\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if (i < nbTrophee-1) {
				texte += ";";
			}
		}
		texte += "]";
		return texte;
	}
}