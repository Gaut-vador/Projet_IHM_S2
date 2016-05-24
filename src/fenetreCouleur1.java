import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class fenetreCouleur1 {
	
	fenetreCouleur1(){
		JPanel p = new JPanel();
		
		JSlider rouge = new JSlider(JSlider.HORIZONTAL, 0,250, 125);
		JSlider vert = new JSlider(JSlider.HORIZONTAL, 0,250, 125);
		JSlider bleu = new JSlider(JSlider.HORIZONTAL, 0,250, 125);
		
		JLabel lab = new JLabel("Choisisez votre première couleur à laide des sliders RVB");
		JButton val = new JButton("Valider");
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new fenetreCouleur1();
	        }
	    });

	}

}
