package VideoPoker;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class Hand { // packaged class
	
	private Card[] currentCards = new Card[5];
	private Card[] hiddenCards = new Card[5];
	private Deck deck;
	
	
	public Hand(Deck initialDeck){ // Constructor (should only be called once)
		this.deck = initialDeck;
		Hand_init();
	}
	
	public void Hand_init(){ // Everytime we want a new hand call this (same object but different cards)
		
		Random randomGenerator = new Random();
		int temp=0;
		int[] n = new int[10]; 
		
		for(int i=0;i<10;i++){
			RandomMaker: while(true){
				temp=randomGenerator.nextInt(52) + 1;
				for(int j=0;j<10;j++){
					if(temp==n[j])
					{
						// Must do another random number (we already chosen this one)
						break;
					}
					if(j==9){
						n[i]=temp;
						break RandomMaker;
					}
				}
				
			}
			
		}	
	    /*String result = "";
	    // i is the position of the card in the deck
	    for (int i = 0; i < 10; i++) {
	        result += "\n" + n[i];
	    }
		System.out.println(result);
		System.out.print("\n");
		*/
			for(int i=0;i<10;i++){
				if(i<5) currentCards[i]=this.deck.GetCard(n[i]-1);
				else hiddenCards[i-5]=this.deck.GetCard(n[i]-1);
		}
		
	}
	
	@Override
	public String toString() {
		return "Hand: [currentCards= " + Arrays.toString(currentCards) + ",\n hiddenCards= " + Arrays.toString(hiddenCards) + "]";
	}
	
	
	// This is the method so the Player can see his hand, we do not show or give any method for the hidden hand (that would be cheating)
	public Card[] GetHand(){
		return currentCards;
	}
	
	
	// Method the Player "calls" to perform hold on the desired cards (basically there will be replacements of cards in the current hand with the hidden hand)
	public void Hold(int[] hold){ // array hold has 5 positions, the elements with 1 we make hold, the ones with zero we replace
		for(int i=0;i<5;i++){
			if(hold[i]==1){
				// Do nothing to that card (hold it)
			}else{
				this.currentCards[i] = this.hiddenCards[i];
			}
		}
		//return this.currentCards; // return the new current hand after the hold
	}
	
	
	
	// This is the method that checks if the final hand wins something or not
	public int CheckHand(){
		int result=0; // 0 = loss, 1 = JacksOrBetter ... 9 = RoyalFlush
		int[] handMap = new int[13];
		boolean pairflag=false;
		int ThreeofK = -1;
		int FourofK = -1;
		int[] Pair = new int[2];
		boolean flush = true;
		boolean straight = false;
		
		// Check for JacksOrBetter, 2Pair, 3ofK, 4ofK
		for(int i=0;i<5;i++){ 
				handMap[this.currentCards[i].getvalue()-2]++; // 2 in position 0 ... ACE in position 12
		}
				
		Pair[0]=-1; Pair[1]=-1;
		for(int i=0;i<13;i++){
			switch (handMap[i]){
			
		        case 2:  //if(i>=9) Jacks or Better
		        		 if(Pair[0]<0) Pair[0]=i; 
		        		 else Pair[1]=i; // Two Pair
		        		 pairflag=true;
	            		 break;
	            		 
		        case 3:  ThreeofK = i; // Three of a Kind
		        		 pairflag=true;
                		 break;
                		 
		        case 4:  FourofK = i; // Four of a Kind
		        		 i=13; // break the for loop, no need to look for more pairs
       		 			 pairflag=true;
       		 			 break;
       		 			 
		        default: break;	 
			}
		}
		
		if(Pair[0]>=9) result=1; // Jacks OR BETTER
		if(Pair[1]!=-1) result=2; // TWO PAIR //////////////////////////////// We know the rank of the cards
		if(ThreeofK!=-1) result=3; // 3 of a Kind
		
		
		
		// Full House:
		if(ThreeofK>=0 && Pair[0]>=0) result=6; // 6 is Full House
		
		
		if(FourofK!=-1) result=4; // 4 of a Kind values more than a Full House
		
		if(!pairflag){
			// Sort the array of cards (by rank):
			SortInteger sorted = new BubbleSort(handMap);
			sorted.sort();
			
			// STRAIGHT
			if(sorted.values[4]==14 && sorted.values[3]-1==4){ // IF the last position has an ACE got to check if we have a straight of the type ACE,2,3,4,5
				straight=true; // ACE can be seen as a value of 1 too
				result = 4;
			}
			if(sorted.values[4]-sorted.values[0]==4){
				straight=true;
				result = 4;
			}
			
			// FLUSH
			int scmp=0;
			switch (this.currentCards[0].getsuit()){
				case DIAMONDS:  
					          scmp=1;
			 		          break;
				case CLUBS:   scmp=2;	  
							  break; 
				case HEARTS:  scmp=3;	  
				 			  break;
				case SPADES:  scmp=4;
					          break;
			}
			int s=0;
			FOR_LOOP:
				for(int i=1;i<5;i++){
					switch (this.currentCards[i].getsuit()){
					case DIAMONDS:  
								  s=1;
								  if(s!=scmp){
									  flush=false;
									  break FOR_LOOP;
								  }
		        		 		  break;
					case CLUBS:   s=2;
								  if(s!=scmp){
									  flush=false;
									  break FOR_LOOP;
								  }
								  break;
					case HEARTS:  s=3;
								  if(s!=scmp){
									  flush=false;
									  break FOR_LOOP;
								  }
	       		 				  break; 
					case SPADES:  s=4;
								  if(s!=scmp){
									  flush=false;
									  break FOR_LOOP;
								  }
								  break;
					}
				}
			
			// STRAIGHT FLUSH
			if(flush && straight){ // result=8 - Straight Flush
				result=8;
			}
			
			// ROYAL FLUSH
			if((flush && straight) && (sorted.values[4]==14)){ // Last card is an ACE
				result = 9; // Royal Flush
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) throws IOException {
		Deck initialDeck = new Deck();
		try {
			initialDeck.CreateDeck();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Hand hand = new Hand(initialDeck);
		//hand.Hand_init(initialDeck);
		System.out.println(hand);
		
		int[] hold = new int[5];
		hold[2]=1;
		hold[3]=1;
		hold[4]=1;

		hand.Hold(hold);
		// Hold everything except the first 2 cards
		System.out.println(hand);
	}
	

}
