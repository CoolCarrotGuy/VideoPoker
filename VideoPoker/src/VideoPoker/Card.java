package VideoPoker;

import java.awt.image.BufferedImage; // for the GUI


// Check out:
// https://github.com/jayduhhkiss/Java/tree/master/VIdeo%20Poker

// This video was seen to help make the GUI and the class Card:
// https://www.youtube.com/watch?v=wRp3hlSV324


public class Card { // should this implement something?
	
	private Rank rank; // rank of the card (ace, king...)
	private Suit suit; // Spades, Clubs, Diamonds or Hearts
	private int value; // Value of the card from 2 (TWO) to 14 (ACE)
	private BufferedImage image; // This is not necessary, but can be used in the future (GUI)
	
	//Constructor:
	public Card(Rank rank, Suit suit, int value, BufferedImage image)
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
	public Suit getsuit()
	{
		return suit;
	}
	public Rank getrank()
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

	
}

