package VideoPoker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Deck { // Only created once in the begining of the program! Not on each game/round
	
	private ArrayList<Card> cards; // List of cards in the deck
	private int ncards; // Number of cards in the deck
	
	public Deck(){
		this.cards= new ArrayList<Card>();
		this.ncards=0;
	}


	public void CreateDeck() throws IOException{
		int i=0; // auxiliary variable to apply the values of each card
		for(Suit suit : Suit.values()){ // this "for" will go through all the possible values of the enum "Suit"
			i=2;
			for(Rank rank : Rank.values()){ // this "for" will go through all the possible values of the enum "Rank"
				this.cards.add(new Card(rank,suit,i,ImageIO.read(new File("Cards/Classic/"+rank+"_of_"+suit+".png"))));
				this.ncards++;
				i++;
			}
		}
	}
	
	// Get how much cards there are on the deck
	public int GetNCards(){
		return this.ncards;
	}
	
	// Get a card from the Deck (by its index)
	public Card GetCard(int ind){
		return this.cards.get(ind);
	}
	

	// Put all the cards of the deck (with their descriptions) in a string
	@Override
	public String toString() {
		//return "Deck [cards=" + cards + "]";
	    String result = "";
	    // i is the position of the card in the deck
	    for (int i = 0; i < this.cards.size(); i++) {
	        result += "\n" + i + " "+ this.cards.get(i);
	    }
	    return result;
	}
	
		
}
