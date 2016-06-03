import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Couleurs {

	HashMap<Color, Integer> nuancier = new HashMap<>();

	int nbCouleur;

	Couleurs() {
		for (int r = 0; r < 256; r++) {
			for (int v = 0; v < 256; v++) {
				for (int b = 0; b < 256; b++) {
					nuancier.put(new Color(r, v, b), convertToNuance(new Color(r, v, b)));
				}
			}
		}
		// System.out.println("Couleurs");
	}

	public int convertToNuance(Color c) {
		return (int) (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
	}

	public Color[][] genererCouleur(int nbCouleur, Color couleur) {

		// System.out.println("genererCouleur");

		Color[][] tab = new Color[nbCouleur][500];
		int cpt = 0;
		int cptErreur = 0;

		int tmp = convertToNuance(couleur);

		for (int i = 0; i < nbCouleur; i++) {

			for (Entry<Color, Integer> e : nuancier.entrySet()) {
				if (e.getValue() == tmp && cptErreur % 1000 == 0) {
					tab[i][cpt] = e.getKey();
					// System.out.println(tab[i][cpt] + "\t"+cpt);

					cpt++;

				}
				cptErreur++;

			}
			cpt = 0;

			if ((tmp + 10) % 255 == 0)
				tmp = 10;
			else
				tmp = (tmp + 10) % 255;
		}

		// System.out.println("genererCouleur 2");
		return tab;
	}

}
