import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class nombreCouleur {
	String [] nombre = new String[10];
	JWindow fenetre = new JWindow ();

	public nombreCouleur(){
		JButton ok = new JButton("OK");
				
		fenetre.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.weightx = 1;
		g.weighty = 1;
		
		g.gridx = 2;
		g.gridy = 0;
		fenetre.getContentPane().add(new JLabel("Selectionner nombre de couleur !"),g);
		
		g.gridx = 2;
		g.gridy = 1;
		remplirTableau();
		fenetre.add(new JComboBox(nombre),g);
		
		
		g.anchor = GridBagConstraints.SOUTHEAST;
		g.insets = new Insets(10, 10, 10, 10);
		fenetre.add(ok ,g);
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.setVisible(false);
			}
			
		});
		
	    fenetre.setPreferredSize(new Dimension(300,200));
	    fenetre.setLocation(100,100);
	    fenetre.pack();
	    fenetre.setVisible(true);
	}
	
	public void remplirTableau(){
		for(int i = 0; i<10; i++){
			nombre[i] = Integer.toString(i+1);
		}
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new nombreCouleur();
	        }
	    });

	}

}
