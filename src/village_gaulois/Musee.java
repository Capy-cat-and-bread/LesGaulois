package village_gaulois;

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
		StringBuilder bld = new StringBuilder();
		bld.append("let musee = [");
		for (int i = 0; i < nbTrophee; i++) {
			bld.append("\"");
			bld.append(trophees[i].getGaulois().getNom());
			bld.append("\", \"");
			bld.append(trophees[i].getEquipement());
			bld.append("\"");
			if (i < nbTrophee - 1) {
				bld.append(";");
			}
		}
		bld.append("]");
		return bld.toString();
	}
}