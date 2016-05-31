import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;


public class testBulder {

	private JFrame frame;
	int tailleR = 51;
	int tailleV = 153;
	int tailleB = 255;
	Canvas ChoixCouleur = new Canvas();
	static int nbC = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			private int n = nbC;

			public void run() {
				try {
					testBulder window = new testBulder(this.n );
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testBulder(int n) {
		this.nbC = n;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500,400);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		ChoixCouleur.setName("ChoixCouleur");
		ChoixCouleur.setBounds(new Rectangle(0, 0, 250, 100));
		ChoixCouleur.setBackground(new Color(tailleR, tailleV, tailleB));
		frame.getContentPane().add(ChoixCouleur,g);
		final JSlider rouge = new JSlider();
		final JSlider vert = new JSlider();
		final JSlider bleu = new JSlider();
		
		//taux rouge
		g.gridy = 1;
		rouge.setMaximum(255);
		rouge.setMinimum(0);
		rouge.setValue(tailleR);
		rouge.setPaintTicks(true);
		rouge.setPaintLabels(true);
		frame.getContentPane().add(rouge,g);
		

		g.gridy = 2;
		final JLabel lblRouge = new JLabel("Rouge: " + tailleR);
		frame.getContentPane().add(lblRouge,g);
		
		rouge.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				lblRouge.setText("Rouge: " + Integer.toString(rouge.getValue()));
				ChoixCouleur.setBackground(new Color(rouge.getValue(), vert.getValue(), bleu.getValue()));
			}
			
		});
		
		
		//taux vert
		g.gridy = 3;
		vert.setMaximum(255);
		vert.setMinimum(0);
		vert.setValue(tailleV);
		vert.setPaintTicks(true);
		vert.setPaintLabels(true);
		frame.getContentPane().add(vert,g);
		
		g.gridy = 4;
		final JLabel lblVert = new JLabel("Vert: " + tailleV);
		frame.getContentPane().add(lblVert,g);
		
		vert.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				lblVert.setText("Vert: " + Integer.toString(vert.getValue()));
				ChoixCouleur.setBackground(new Color(rouge.getValue(), vert.getValue(), bleu.getValue()));
			}
			
		});
		
		//taux bleu
		g.gridy = 5;
		bleu.setMaximum(255);
		bleu.setMinimum(0);
		bleu.setValue(tailleB);
		bleu.setPaintTicks(true);
		bleu.setPaintLabels(true);
		frame.getContentPane().add(bleu,g);
		
		g.gridy = 6;
		final JLabel lblBleu = new JLabel("Bleu: " + tailleB);
		frame.getContentPane().add(lblBleu,g);
		
		bleu.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				lblBleu.setText("Bleu: " + Integer.toString(bleu.getValue()));
				ChoixCouleur.setBackground(new Color(rouge.getValue(), vert.getValue(), bleu.getValue()));
			}
			
		});
		
		//bouton
		g.gridy = 7;
		JButton button = new JButton("Valider");
		frame.getContentPane().add(button, g);
	}

}
