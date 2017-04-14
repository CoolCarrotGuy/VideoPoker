package VideoPoker;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage; // for the GUI
import java.io.File;
import java.io.IOException; // for the exception

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Check out:
// https://github.com/jayduhhkiss/Java/tree/master/VIdeo%20Poker

// This video was seen to help make the GUI and the class Card:
// https://www.youtube.com/watch?v=wRp3hlSV324


public class Card { // should this implement something?
	
	private String rank; // rank of the card (ace, king...)
	private String suit; // Spades, Clubs, Diamonds or Hearts
	private int value; // Value of the card from 1 (ace) to 13 (king), but these is more relevant to "numbered cards" (no Jack,Queen,King or Ace)
	private BufferedImage image; // This is not necessary, but can be used in the future (GUI)
	
	//Constructor:
	public Card(String rank, String suit, int value, BufferedImage image)
	{
		this.rank=rank;
		this.suit=suit;
		this.value=value;
		this.image=image;
	}
	
	public int getvalue()
	{
		return value;
	}
	public String getsuit()
	{
		return suit;
	}
	public String getrank()
	{
		return rank;
	}
	public BufferedImage getImage()
	{
		return image;
	}
	
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (value = " + value + ")";
	}


	public static void main(String[] args) throws IOException // Throw exception so we see the errors (e.g: if the image does not exist in the folder)
	{
		Card card1 = new Card("Spades","Ace",1,ImageIO.read(new File("Ace_of_spades.jpg")));
		
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
		
		
		
	}
	
}

