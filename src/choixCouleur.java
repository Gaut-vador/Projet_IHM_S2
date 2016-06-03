import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;


public class choixCouleur {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel choix = new JPanel();
	JList canva = new JList();
	Color [][] couleur;
	int i=0;
	
	choixCouleur(Color [][] c, int nbC){
		this.couleur = c;
		
		panel.add(Box.createVerticalStrut(10));
		
		//partie avec toute les canvas de couleur
		for(int k = 0; k < nbC; k++){
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			Canvas c1 = new Canvas();
			c1.setBounds(new Rectangle(0, 0, 150, 50));
			c1.setBackground(new Color(k, k*5, k*20));
			panel.add(c1);
			c1.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					for(int j = 0; j < 25 ; j++){
						choix.setLayout(new BoxLayout(choix, BoxLayout.X_AXIS));
						Canvas c2 = new Canvas();
						c2.setBounds(new Rectangle(0, 0, 150, 50));
						c2.setBackground(couleur[i][j]);
						choix.add(c2);
						System.out.println("coucou");
					}
					
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
			});
			panel.add(Box.createVerticalStrut(10));
			

		}
		//fenetre afficher
		frame.getContentPane().add(panel, BorderLayout.WEST);	
		frame.getContentPane().add(choix,BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(600,400));
	    frame.setLocation(100,100);
	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void construireJList(){
		Canvas [] ca = new Canvas [couleur[0].length];
		for(int i = 0; i < couleur.length; i++){
			for(int j = 0; j< couleur[0].length; j++){
				ca
			}
		}
	}

}
