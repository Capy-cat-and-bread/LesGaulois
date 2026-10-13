package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert isPreConditionVerified(forceCoup);
		int forceDebut = force;
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		assert isInvariantVerified();
		assert isPostConditionVerified(forceDebut, force);
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		default:
			ajouterEquipement(equipement);
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe d'un " + equipement + ".");
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	private boolean isPreConditionVerified(int forceCoup) {
		return forceCoup > 0;
	}

	private boolean isPostConditionVerified(int forceDebut, int forceFin) {
		if (forceDebut == 0) {
			return forceDebut == forceFin;
		} else {
			return forceDebut > forceFin;
		}
	}

	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		// System.out.println(Equipement.CASQUE);
		// System.out.println(Equipement.BOUCLIER);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
