package objets;

public class Chaudron {
	public int quantitePotion = 0;
	public int forcePotion = 0;

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	public int prendreLouche() {
		if (quantitePotion > 0) {
			quantitePotion--;
		} else {
			forcePotion = 0;
		}
		return forcePotion;
	}
}
