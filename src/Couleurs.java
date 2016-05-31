import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Couleurs {

	HashMap<Color, Integer> nuancier = new HashMap<>();
	int nbCouleur;

	Couleurs() {
		for (int r = 0; r < 256; r++) {
			for (int v = 0; v < 256; r++) {
				for (int b = 0; b < 256; r++) {
					nuancier.put(new Color(r, v, b), convertToNuance(new Color(r, v, b)));
				}
			}
		}
	}

	public int convertToNuance(Color c) {
		return (int) (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
	}

	public ArrayList[] genererCouleur(int nbCouleur, Color couleur) {
		
		ArrayList<Color> tab[] = new ArrayList[nbCouleur];
		int tmp = convertToNuance(couleur);
		for (int i = 0; i < nbCouleur; i++) {
			for (ArrayList<Color> A : tab) {
				A = new ArrayList<>();
				for (Entry<Color, Integer> e : nuancier.entrySet()) {
					if (e.getValue() == tmp) {
						A.add(e.getKey());
					}
				}
			}

			tmp = (tmp + 10) % 255;
		}

		return tab;
	}

}
