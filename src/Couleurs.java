import java.awt.Color;

public class Couleurs {

	NuanceDeGris nuanceDeGris;
	

	Couleurs() {
	}

	Couleurs(int r, int g, int b, int nbcouleur) {	
		nuanceDeGris = new NuanceDeGris(nbcouleur);
		this.nuanceDeGris.setNuance(nuanceDeGris.convertToNuance(new Color(r, g, b)), new Color(r, g, b));	
	}
	
	Couleurs(int r, int g, int b) {	
		
	}
	
	
	

}
