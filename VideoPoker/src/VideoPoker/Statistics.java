package VideoPoker;
/*
INPUTS
1           Jacks or Better N1 
2           Two Pair N2
3           Three of a Kind N3
4           Straight N4
5           Flush N5
6           Full house N6
7           Four of a Kind N7      5-K
8			Four of a Kind N7	   2-4
9			Four of a Kind N7	   Aces
10          Straight Flush N8
11          Royal Flush N9
12          Other N10
*/

import java.util.Arrays;

/*
Total N11
Credit N12 (N13%)
*/

import java.util.stream.*;

public class Statistics {

	int[] Hands = new int[10];//[N1 N2 N3 N4 N5 N6 N7 N8 N9 N10]

	void AddHand(int hand){
		if(hand==7||hand==8||hand==9){
			Hands[7]++;
			return;
		}
		if(hand==10||hand==11||hand==12){
			Hands[hand-2]++;
			return;
		}
		//if hand == 1 or 2, 3, 4, 5, 6
		Hands[hand]++;
		return;
	}
	
	int GetTotalHands(){
		int total = IntStream.of(Hands).sum();
		return total;
	}
	
	int CalculateHandPayment(int hand, int credits){
		
		switch(hand){
		
			case 1:
				return credits;
			
			case 2:
				return credits;
		
			case 3:
				return (3*credits);
				
			case 4:
				return (5*credits);
				
			case 5:
				return (7*credits);
				
			case 6:
				return (10*credits);
				
			case 7:
				return (50*credits);
				
			case 8:
				return (80*credits);
				
			case 9:
				return (160*credits);
				
			case 10:
				return (50*credits);
				
			case 11:
				if (credits==5){
					return 4000;
				}
				else{
					return (250*credits);
				}
				
			case 12:
				return 0;
		}
		return 0;
	}

	@Override
	public String toString() {	
		return "Hand                   Nb\n"
			 + "Jacks or Better        " + Hands[1] + "\n"
		     + "Two Pair               " + Hands[2] + "\n"
		     + "Three of a Kind        " + Hands[3] + "\n"
		     + "Straight 		       " + Hands[4] + "\n"
		     + "Flush 		      	   " + Hands[5] + "\n"
		     + "Full house 			   " + Hands[6] + "\n"
		     + "Four of a Kind 		   " + (Hands[7]+Hands[8]+Hands[9]) + "\n"
		     + "Straight Flush	       " + Hands[10] + "\n"
		     + "Royal Flush 		   " + Hands[11] + "\n"
		     + "Other 				   " + Hands[12] + "\n"
		     + "Total 				   " + GetTotalHands() + "\n"
		     + "Credit N12 (N13%)      " + Hands[1] + "\n";
	}              /////VER O N12 E O N13
	
	public static void main(String[] args) {
		System.exit(1);
	}
	
}
