package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
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
		force = force - forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		assert isInvariantVerified();
		assert isPostConditionVerified(forceDebut, force);
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	private boolean isPreConditionVerified(int forceCoup) {
		return forceCoup > 0; 
	}
	
	private boolean isPostConditionVerified(int forceDebut, int forceFin) {
		if (forceDebut==0) {
			return forceDebut == forceFin;
		} else {
			return forceDebut > forceFin;
		}
	}

	@Override
	public String toString() {
		return nom;
	}
}
