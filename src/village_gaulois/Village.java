package village_gaulois;

import personnages.Gaulois;

public class Village {

	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMax, Gaulois chef) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMax];
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {

	}

	public Gaulois trouverVillageois(int numVillageois) {

	}

	public void afficherVillage() {

	}

}
