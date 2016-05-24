import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

public class Couleurs {

	HashMap<Integer, Color> nuancier = new HashMap<>();
	int nbCouleur;

	Couleurs(int r, int g, int b, int nbCouleur) {
		this.nbCouleur = nbCouleur;
		nuancier.put(convertToNuance(new Color(r, g, b)), new Color(r, g, b));
		genererNuanceGris(nbCouleur);
	}

	public int convertToNuance(Color c) {
		return (int) (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
	}

	void genererNuanceGris(int nb) {
		Random rng = new Random();
		int[] alea = new int[this.nbCouleur];
		do {
			for (int i = 1; i <= alea.length; i++) {
				alea[i] = rng.nextInt();
			}
		} while (!verifAlea(alea));

	}

	boolean verifAlea(int[] tab) {
		for (int i = 0; i < tab.length - 1; i++) {
			for (int j = i; j < tab.length - 1; j++) {
				if ((tab[j] > (tab[j + 1] + 10) || tab[j] < (tab[j + 1] - 10)))
					return false;
			}
		}
		return true;
	}

}
