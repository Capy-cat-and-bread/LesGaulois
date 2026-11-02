package personnages;

import java.util.Iterator;

import objets.Equipement;
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
			for (int i = 0; tropheesTemp != null && i < tropheesTemp.length; i++, nbTrophees++) {
				if (tropheesTemp[i] != null) {
					trophees[nbTrophees] = tropheesTemp[i];
					tropheesTemp[i] = null;
				}
			}
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else if (village.getChef() == this) {
			parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".");
		} else {
			parler("Bonjour, je m'apppelle " + nom + ". J'habite le village : " + village.getNom() + ".");
		}
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			String texte = "Je donne au musee tous mes trophees : ";
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				texte += "\n - " + trophees[i];
				trophees[i] = null;
			}
			nbTrophees = 0;
			parler(texte);
		}
	}
	
}
