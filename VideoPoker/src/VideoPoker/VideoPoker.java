package VideoPoker;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VideoPoker {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		////////////////////////////// The images are too big, we got to change the size
		
		//Images on the folder Cards/Classic/
		
		// Create an image to test if everything is okay: 
		Card card1 = new Card(Rank.ACE,Suit.SPADES,14,ImageIO.read(new File("Cards/Classic/"+Rank.ACE+"_of_"+Suit.SPADES+".png")));
		
		System.out.println(card1);
		
		
		
		
		// To display the images:
		JFrame window = new JFrame("Card Display"); 
		window.setSize(400,600); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		
		JLabel cardLabel = new JLabel(new ImageIcon(card1.getImage()));
		cardLabel.setSize(300,400);
		
		contentPanel.add(cardLabel);
		
		window.add(contentPanel);
		////////////////////////////////////////////////////////////////////////
		

		// Test if the Deck (all 52 cards) is well created
		Deck initialDeck = new Deck();
		initialDeck.CreateDeck();
		
		System.out.println(initialDeck);
		
		
	}
	
	
	

}
