package objets;

public class Chaudron {
	public int quantitePotion;
	public int forcePotion;

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return this.quantitePotion>0;
	}

	public int prendreLouche() {
		//
	}
}
