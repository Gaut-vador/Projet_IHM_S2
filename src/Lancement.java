import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lancement extends JFrame {
	
  	JWindow menu = new JWindow();

	  public Lancement(){
		  	//creation fenetre
		    menu.setPreferredSize(new Dimension(500,500));	    
		    
		    ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/lance.jpg")); // charger l'image en image icone
		    Image image = imageIcon.getImage(); //  pour la transformer 
		    Image newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH); 
		    imageIcon = new ImageIcon(newimg);  
		    JLabel play = new JLabel();
		    play.setIcon(imageIcon);
		    menu.getContentPane().add(play);
		  	menu.setVisible(true);
		  	//menu.setLocationRelativeTo(null);
		  	menu.pack();
		  	
		  	play.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					menu.setVisible(false); // on fait disparaitre la première fenetre
					
					Projet projet = new Projet();
					projet.frame.pack();
					projet.frame.setVisible(true);
					projet.frame.setLocationRelativeTo(null); // on fait apparaitre fenetre avec choix
					
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseReleased(MouseEvent arg0) {}
		  		
		  	});

	  }
}
	  
