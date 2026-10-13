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
		chef.setVillage(this);
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", 30, abraracourcix);
		// village.trouverVillageois(30);

		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterVillageois(obelix);
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
		// Gaulois gaulois = village.trouverVillageois(1);
		// System.out.println(gaulois);
		// gaulois = village.trouverVillageois(2);
		// System.out.println(gaulois);
		village.afficherVillageois();
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();

	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.setVillage(this);
		}
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois >= 1 && numVillageois <= nbVillageois) {
			return villageois[numVillageois - 1];
		} else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}

	public void afficherVillageois() {
		if (nbVillageois > 0) {
			System.out
					.println("Dans le village \"" + nom + "\" du chef " + chef + " \nvivent les légendaires gaulois :");
			for (Gaulois gaulois : villageois) {
				if (gaulois != null) {
					System.out.println("- " + gaulois);
				}
			}
		}
	}

}
