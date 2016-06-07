import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Projet {

	JFrame frame;
	int nbC = 1;
	Color couleurSelec = new Color(51, 153, 255);

	public Projet() {
		frame = new JFrame("Nombre de couleur");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel PchoixCouleur = new JPanel();

		JLabel LnbCouleur = new JLabel("Combien de couleurs voulez vous?");
		JComboBox nbCouleur = new JComboBox(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
		JButton ok = new JButton("OK");

		PchoixCouleur.add(LnbCouleur);
		PchoixCouleur.add(nbCouleur);
		PchoixCouleur.add(ok);

		frame.getContentPane().add(PchoixCouleur);

		nbCouleur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nbC = nbCouleur.getSelectedIndex() + 1;
			}
		});

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(PchoixCouleur);

				JPanel Pbouton = new JPanel();
				JPanel Plabel = new JPanel();
				
				Pbouton.setLayout(new BoxLayout(Pbouton, BoxLayout.Y_AXIS));
				Plabel.setLayout(new BoxLayout(Plabel, BoxLayout.Y_AXIS));
				Plabel.add(Box.createVerticalStrut(10));
				
				ArrayList<JButton> tabBouton = new ArrayList<>();
				ArrayList<JLabel> tabLabel = new ArrayList<>();

				for (int i = 0; i < nbC; i++) {
					tabBouton.add(new JButton("Couleur " + (i+1)));
					Pbouton.add(tabBouton.get(i), BorderLayout.WEST);
					tabBouton.get(i).setVisible(true);
					tabLabel.add(new JLabel("Nuance de gris " + (i+1)));
					tabLabel.get(i).setOpaque(true);
					Plabel.add(tabLabel.get(i), BorderLayout.EAST);
				}
				
				
				for (JButton b : tabBouton) {
					b.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int idx = tabBouton.indexOf(b);
							
							b.setBackground(couleurSelec);
							tabBouton.get(idx).setBackground(couleurSelec);
							int gris=((int)(b.getBackground().getRed()*0.3+b.getBackground().getGreen()*0.59+b.getBackground().getBlue()*0.11));
							tabLabel.get(idx).setBackground(new Color(gris,gris,gris));
						}
					});
				}

				// choix de la couleur
				JPanel choixDeCouleur = new JPanel();
				JPanel Pslider = new JPanel();
				Pslider.setLayout(new BoxLayout(Pslider, BoxLayout.Y_AXIS));
				
				int tailleR = 51;
				int tailleV = 153;
				int tailleB = 255;
				Canvas ChoixCouleur = new Canvas();

				

				ChoixCouleur.setName("ChoixCouleur");
				ChoixCouleur.setBounds(new Rectangle(0, 0, 250, 100));
				ChoixCouleur.setBackground(new Color(tailleR, tailleV, tailleB));

				choixDeCouleur.add(ChoixCouleur, BorderLayout.WEST);
				final JSlider rouge = new JSlider();
				final JSlider vert = new JSlider();
				final JSlider bleu = new JSlider();

				// taux rouge
			
				rouge.setMaximum(255);
				rouge.setMinimum(0);
				rouge.setValue(tailleR);
				rouge.setPaintTicks(true);
				rouge.setPaintLabels(true);
				Pslider.add(rouge);

				final JLabel lblRouge = new JLabel("Rouge: " + tailleR);
				Pslider.add(lblRouge);

				rouge.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						lblRouge.setText("Rouge: " + Integer.toString(rouge.getValue()));
						ChoixCouleur.setBackground(new Color(rouge.getValue(), vert.getValue(), bleu.getValue()));
						couleurSelec = new Color(rouge.getValue(), vert.getValue(), bleu.getValue());
					}

				});
				// taux vert
				
				vert.setMaximum(255);
				vert.setMinimum(0);
				vert.setValue(tailleV);
				vert.setPaintTicks(true);
				vert.setPaintLabels(true);
				Pslider.add(vert);

				
				final JLabel lblVert = new JLabel("Vert: " + tailleV);
				Pslider.add(lblVert);
				vert.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						lblVert.setText("Vert: " + Integer.toString(vert.getValue()));
						ChoixCouleur.setBackground(new Color(rouge.getValue(), vert.getValue(), bleu.getValue()));
						couleurSelec = new Color(rouge.getValue(), vert.getValue(), bleu.getValue());
					}
				});

				// taux bleu
				
				bleu.setMaximum(255);
				bleu.setMinimum(0);
				bleu.setValue(tailleB);
				bleu.setPaintTicks(true);
				bleu.setPaintLabels(true);
				Pslider.add(bleu);

				
				final JLabel lblBleu = new JLabel("Bleu: " + tailleB);
				Pslider.add(lblBleu);

				bleu.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						lblBleu.setText("Bleu: " + Integer.toString(bleu.getValue()));
						ChoixCouleur.setBackground(new Color(rouge.getValue(), vert.getValue(), bleu.getValue()));
						couleurSelec = new Color(rouge.getValue(), vert.getValue(), bleu.getValue());
					}
				});

				choixDeCouleur.add(Pslider, BorderLayout.CENTER);
				JPanel couleurs =new JPanel();
				couleurs.add(Pbouton, BorderLayout.WEST);
				couleurs.add(Plabel, BorderLayout.EAST);
				
				frame.getContentPane().add(couleurs, BorderLayout.WEST);
				frame.getContentPane().add(choixDeCouleur, BorderLayout.CENTER);
				frame.setSize(600, 400);
				frame.setLocationRelativeTo(null);
			}
		});

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Lancement l = new Lancement();
				
			}
		});

	}

}
