package personnages;

import objets.Equipement;
import objets.Trophee;
import village_gaulois.Musee;
import village_gaulois.Village;

public class Gaulois {
	private int force;
	private int nbTrophees;
	private String nom;
	private int effetPotion = 1;
	private Village village;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesTemp = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		if (tropheesTemp != null) {
			for (int i = 0; i < tropheesTemp.length; i++) {
				if (tropheesTemp[i] != null) {
					trophees[nbTrophees] = tropheesTemp[i];
					nbTrophees++;
				}
			}
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		StringBuilder phrase = new StringBuilder();
		phrase.append("Bonjour, je m'appelle ");
		phrase.append(nom);
		phrase.append(". ");
		if (village == null) {
			phrase.append("Je voyage de villages en villages.");
		} else {
			if (village.getChef() == this) {
				phrase.append("Je suis le chef du village : ");
			} else {
				phrase.append("J'habite le village : ");
			}
			phrase.append(village.getNom());
			phrase.append(".");
		}
		parler(phrase.toString());
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			StringBuilder texte = new StringBuilder("Je donne au musee tous mes trophees : ");
			for (int i = 0; i < nbTrophees; i++) {
				Trophee nouveauTrophee = new Trophee(this, trophees[i]);
				musee.donnerTrophees(this, nouveauTrophee);
				texte.append("\n - ");
				texte.append(trophees[i]);
				trophees[i] = null;
			}
			nbTrophees = 0;
			parler(texte.toString());
		}
	}

}
