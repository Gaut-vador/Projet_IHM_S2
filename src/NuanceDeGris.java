import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class NuanceDeGris {

	int[] nuance;
	Color[] couleurs;
	ArrayList<Color> couleursProposees = new ArrayList<>();
	
	
	public NuanceDeGris(int nbcouleur){
		nuance = new int[nbcouleur];
		couleurs = new Color[nbcouleur];
	}
	
	public void setNuance(int n, Color c){
		nuance[0] = n;
		couleurs[0] = c;
	}
	
	
	
	public int convertToNuance(Color c){
		return (int) (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
	}
	
	public int getNuance(int pos){
		return nuance[pos];
	}
	
	public Color getCouleur(int pos){
		return couleurs[pos];
	}
	
	public void genererNuance(){
		Random rng = new Random();
		int random = rng.nextInt(255)+1;
		
		
		
		for(int i=1; i< nuance.length; i++){
			nuance[i] = random;
		}
	}
	
	
}
